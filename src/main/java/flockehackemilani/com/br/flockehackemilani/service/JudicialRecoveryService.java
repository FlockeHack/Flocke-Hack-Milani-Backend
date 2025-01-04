package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.entity.FileEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialEventEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialRecoveryEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.TypeEnum;
import flockehackemilani.com.br.flockehackemilani.exceptions.FileDataNotCaughtException;
import flockehackemilani.com.br.flockehackemilani.exceptions.JudicialRecoveryNotFoundException;
import flockehackemilani.com.br.flockehackemilani.mapper.FileMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.JudicialMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.ResponseMapper;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialRecoveryRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialEventResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialRecoveryResponse;
import flockehackemilani.com.br.flockehackemilani.repository.JudicialEventRepository;
import flockehackemilani.com.br.flockehackemilani.repository.JudicialRecoveryRepository;
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
public class JudicialRecoveryService {

  private final JudicialRecoveryRepository judicialRecoveryRepository;
  private final JudicialEventRepository eventRepository;
  private final FileService fileService;

  private final ProtocolService protocolService;

  public List<JudicialRecoveryResponse> getAllJudicialRecovery() {
    final List<JudicialRecoveryEntity> recoveries = judicialRecoveryRepository.findAll();

    if (recoveries.isEmpty()) {
      return Collections.emptyList();
    }

    return recoveries.stream()
            .filter(recovery -> Objects.nonNull(recovery.getName()))
            .map(ResponseMapper::mapToJudicialRecoveryResponse)
            .toList();
  }

  public JudicialRecoveryResponse getJudicialRecoveryById(final String id) {
    final JudicialRecoveryEntity entity = judicialRecoveryRepository.findById(id)
            .orElseThrow(() -> new JudicialRecoveryNotFoundException("Recuperação judicial não encontrada para o id: %s".formatted(id)));

    return ResponseMapper.mapToJudicialRecoveryResponse(entity);
  }

  public JudicialRecoveryResponse createJudicialRecovery(final JudicialRecoveryRequest request) {
    log.info("[JUDICIAL-RECOVERY] - Creating judicial recovery.");

    final String protocolNumber = protocolService.buildProtocolNumber(SegmentEnum.JUDICIAL_RECOVERY);

    final JudicialRecoveryEntity entity = JudicialMapper.mapToJudicialRecoveryEntity(request, protocolNumber);
    final JudicialRecoveryEntity savedEntity = judicialRecoveryRepository.save(entity);

    log.info("[JUDICIAL-RECOVERY] - Created judicial recovery with id: {} and protocol number: {}", savedEntity.getId(), protocolNumber);
    return ResponseMapper.mapToJudicialRecoveryResponse(savedEntity);
  }

  public List<JudicialEventResponse> getAllJudicialEventByProtocolNumber(final String protocolNumber) {
    final List<JudicialEventEntity> events = eventRepository.findAllByProtocolNumber(protocolNumber);

    if (events.isEmpty()) {
      return Collections.emptyList();
    }

    return events.stream()
            .map(ResponseMapper::mapToJudicialEventResponse)
            .toList();
  }

  public JudicialEventResponse createJudicialEvent(final JudicialEventRequest request, final MultipartFile file) {
    log.info("[JUDICIAL-RECOVERY] - Creating judicial recovery event for protocol number: {}", request.getProtocolNumber());
    final String protocolNumber = request.getProtocolNumber();
    final byte[] fileData;

    try {
      fileData = file.getBytes();
    } catch (IOException err) {
      log.error("[JUDICIAL-RECOVERY] - Error creating judicial event for protocol number: {}", protocolNumber);
      throw new FileDataNotCaughtException(err.getMessage(), err);
    }

    final FileEntity fileEntity = FileMapper.mapToFileEntity(SegmentEnum.JUDICIAL_RECOVERY, TypeEnum.OTHER, protocolNumber, file.getOriginalFilename(), fileData);
    final FileEntity fileSaved = fileService.saveFile(fileEntity);

    final JudicialEventEntity eventEntity = JudicialMapper.mapToJudicialEventEntity(request, fileSaved.getId());
    final JudicialEventEntity eventEntitySaved = eventRepository.save(eventEntity);

    log.info("[JUDICIAL-RECOVERY] - Created judicial recovery event with id: {} and protocol: {}", fileEntity.getId(), protocolNumber);
    return ResponseMapper.mapToJudicialEventResponse(eventEntitySaved);
  }

}
