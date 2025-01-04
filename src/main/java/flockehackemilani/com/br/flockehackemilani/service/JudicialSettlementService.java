package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.entity.FileEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialEventEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialSettlementEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.TypeEnum;
import flockehackemilani.com.br.flockehackemilani.exceptions.FileDataNotCaughtException;
import flockehackemilani.com.br.flockehackemilani.exceptions.JudicialSettlementNotFoundException;
import flockehackemilani.com.br.flockehackemilani.mapper.FileMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.JudicialMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.ResponseMapper;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialSettlementRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialEventResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialSettlementResponse;
import flockehackemilani.com.br.flockehackemilani.repository.JudicialEventRepository;
import flockehackemilani.com.br.flockehackemilani.repository.JudicialSettlementRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class JudicialSettlementService {

  private final JudicialSettlementRepository judicialSettlementRepository;
  private final JudicialEventRepository eventRepository;
  private final FileService fileService;
  private final ProtocolService protocolService;

  public List<JudicialSettlementResponse> getAllJudicialSettlement() {
    final List<JudicialSettlementEntity> judicialSettlementEntityList = judicialSettlementRepository.findAll();

    if (judicialSettlementEntityList.isEmpty()) {
      return Collections.emptyList();
    }

    return judicialSettlementEntityList.stream()
            .filter(settlement -> Objects.nonNull(settlement.getName()))
            .map(ResponseMapper::mapToJudicialSettlementResponse)
            .toList();
  }

  public JudicialSettlementResponse getJudicialSettlementById(final String id) {
    final JudicialSettlementEntity entity = judicialSettlementRepository.findById(id)
            .orElseThrow(() -> new JudicialSettlementNotFoundException("Processo de liquidação não encontrado para o id: %s".formatted(id)));

    return ResponseMapper.mapToJudicialSettlementResponse(entity);
  }

  public JudicialSettlementResponse createJudicialSettlement(final JudicialSettlementRequest request) {
    log.info("[JUDICIAL-SETTLEMENT] - Creating judicial settlement");
    final String protocolNumber = protocolService.buildProtocolNumber(SegmentEnum.JUDICIAL_SETTLEMENT);

    final JudicialSettlementEntity entity = JudicialMapper.mapToJudicialSettlementEntity(request, protocolNumber);
    final JudicialSettlementEntity savedEntity = judicialSettlementRepository.save(entity);

    log.info("[JUDICIAL-SETTLEMENT] - Created judicial settlement with id: {} and protocol number: {}", savedEntity.getId(), protocolNumber);
    return ResponseMapper.mapToJudicialSettlementResponse(savedEntity);
  }

  public List<JudicialEventResponse> getAllJudicialEventByProcessNumber(final String protocolNumber) {
    final List<JudicialEventEntity> events = eventRepository.findAllByProtocolNumber(protocolNumber);

    if (events.isEmpty()) {
      return Collections.emptyList();
    }

    return events.stream()
            .map(ResponseMapper::mapToJudicialEventResponse)
            .toList();
  }

  public JudicialEventResponse createJudicialEvent(final JudicialEventRequest request, final MultipartFile file) {
    log.info("[JUDICIAL-SETTLEMENT] - Creating judicial settlement event for protocol number: {}", request.getProtocolNumber());
    final String protocolNumber = request.getProtocolNumber();
    final byte[] fileData;

    try {
      fileData = file.getBytes();
    } catch (IOException err) {
      log.error("[JUDICIAL-SETTLEMENT] - Error creating settlement event for protocol number: {}", protocolNumber);

      throw new FileDataNotCaughtException(err.getMessage(), err);
    }

    final FileEntity fileEntity = FileMapper.mapToFileEntity(SegmentEnum.JUDICIAL_SETTLEMENT, TypeEnum.OTHER, protocolNumber, file.getOriginalFilename(), fileData);
    final FileEntity fileSaved = fileService.saveFile(fileEntity);

    final JudicialEventEntity eventEntity = JudicialMapper.mapToJudicialEventEntity(request, fileSaved.getId());
    final JudicialEventEntity eventEntitySaved = eventRepository.save(eventEntity);

    log.info("[JUDICIAL-SETTLEMENT] - Created judicial settlement event with id: {} and protocol: {}", fileEntity.getId(), protocolNumber);
    return ResponseMapper.mapToJudicialEventResponse(eventEntitySaved);
  }

}
