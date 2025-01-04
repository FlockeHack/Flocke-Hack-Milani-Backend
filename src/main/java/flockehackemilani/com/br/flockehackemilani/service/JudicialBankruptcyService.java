package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.entity.FileEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialBankruptcyEntity;
import flockehackemilani.com.br.flockehackemilani.entity.JudicialEventEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.TypeEnum;
import flockehackemilani.com.br.flockehackemilani.exceptions.FileDataNotCaughtException;
import flockehackemilani.com.br.flockehackemilani.exceptions.ResourceNotFoundException;
import flockehackemilani.com.br.flockehackemilani.mapper.FileMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.JudicialMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.ResponseMapper;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialBankruptcyRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialBankruptcyResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialEventResponse;
import flockehackemilani.com.br.flockehackemilani.repository.JudicialBankruptcyRepository;
import flockehackemilani.com.br.flockehackemilani.repository.JudicialEventRepository;
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
public class JudicialBankruptcyService {

  private final JudicialBankruptcyRepository judicialBankruptcyRepository;
  private final JudicialEventRepository eventRepository;
  private final FileService fileService;

  private final ProtocolService protocolService;

  public List<JudicialBankruptcyResponse> getAllJudicialBankruptcy() {
    final List<JudicialBankruptcyEntity> bankruptcies = judicialBankruptcyRepository.findAll();

    if (bankruptcies.isEmpty()) {
      return Collections.emptyList();
    }

    return bankruptcies.stream()
            .filter(bankruptcy -> Objects.nonNull(bankruptcy.getName()))
            .map(ResponseMapper::mapToJudicialBankruptcyResponse)
            .toList();
  }

  public JudicialBankruptcyResponse getJudicialBankruptcyById(final String id) throws ResourceNotFoundException {
    final JudicialBankruptcyEntity entity = judicialBankruptcyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Processo de falência não encontrado para o id: %s".formatted(id)));

    return ResponseMapper.mapToJudicialBankruptcyResponse(entity);
  }

  public JudicialBankruptcyResponse createJudicialBankruptcy(final JudicialBankruptcyRequest request) {
    log.info("[JUDICIAL-BANKRUPTCY] - Creating judicial bankruptcy.");
    final String protocolNumber = protocolService.buildProtocolNumber(SegmentEnum.JUDICIAL_BANKRUPTCY);

    final JudicialBankruptcyEntity entity = JudicialMapper.mapToJudicialBankruptcyEntity(request, protocolNumber);
    final JudicialBankruptcyEntity savedEntity = judicialBankruptcyRepository.save(entity);

    log.info("[JUDICIAL-BANKRUPTCY] - Created judicial bankruptcy with id: {} and protocol number: {}", savedEntity.getId(), protocolNumber);
    return ResponseMapper.mapToJudicialBankruptcyResponse(savedEntity);
  }

  public List<JudicialEventResponse> getAllJudicialEventByProcessNumber(final String processNumber) {
    final List<JudicialEventEntity> events = eventRepository.findAllByProtocolNumber(processNumber);

    if (events.isEmpty()) {
      return Collections.emptyList();
    }

    return events.stream()
            .map(ResponseMapper::mapToJudicialEventResponse)
            .toList();
  }

  public JudicialEventResponse createJudicialEvent(final JudicialEventRequest request, final MultipartFile file) {
    log.info("[JUDICIAL-BANKRUPTCY] - Creating judicial bankruptcy event for protocol number: {}", request.getProtocolNumber());
    final String protocolNumber = request.getProtocolNumber();
    final byte[] fileData;

    try {
      fileData = file.getBytes();
    } catch (IOException err) {
      log.error("[JUDICIAL-BANKRUPTCY] - Error creating judicial event for protocol number: {}", protocolNumber);
      throw new FileDataNotCaughtException(err.getMessage(), err);
    }

    final FileEntity fileEntity = FileMapper.mapToFileEntity(SegmentEnum.JUDICIAL_BANKRUPTCY, TypeEnum.OTHER, protocolNumber, file.getOriginalFilename(), fileData);
    final FileEntity fileSaved = fileService.saveFile(fileEntity);

    final JudicialEventEntity eventEntity = JudicialMapper.mapToJudicialEventEntity(request, fileSaved.getId());
    final JudicialEventEntity eventEntitySaved = eventRepository.save(eventEntity);

    log.info("[JUDICIAL-BANKRUPTCY] - Created judicial recovery event with id: {} and protocol: {}", fileEntity.getId(), protocolNumber);
    return ResponseMapper.mapToJudicialEventResponse(eventEntitySaved);
  }

}
