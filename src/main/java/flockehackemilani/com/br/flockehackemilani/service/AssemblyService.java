package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.entity.AssemblyEntity;
import flockehackemilani.com.br.flockehackemilani.entity.AssemblyEventEntity;
import flockehackemilani.com.br.flockehackemilani.entity.FileEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.AssemblyEventTypeEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.TypeEnum;
import flockehackemilani.com.br.flockehackemilani.exceptions.MissingInformationRequestException;
import flockehackemilani.com.br.flockehackemilani.exceptions.ResourceNotFoundException;
import flockehackemilani.com.br.flockehackemilani.mapper.AssemblyMapper;
import flockehackemilani.com.br.flockehackemilani.mapper.ResponseMapper;
import flockehackemilani.com.br.flockehackemilani.model.request.AssemblyEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.AssemblyRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.AssemblyEventResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.AssemblyResponse;
import flockehackemilani.com.br.flockehackemilani.repository.AssemblyEventRepository;
import flockehackemilani.com.br.flockehackemilani.repository.AssemblyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class AssemblyService {

  private final AssemblyRepository assemblyRepository;
  private final AssemblyEventRepository assemblyEventRepository;
  private final ProtocolService protocolService;
  private final FileService fileService;

  public List<AssemblyResponse> getAllAssemblies() {
    return assemblyRepository.findAll()
            .stream()
            .map(ResponseMapper::mapToAssemblyResponse)
            .toList();
  }

  public AssemblyResponse getAssemblyByProtocolNumber(final String protocolNumber) throws ResourceNotFoundException {
    final AssemblyEntity entity = assemblyRepository.findByProtocolNumber(protocolNumber)
            .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado uma assembleia para o numero de protocolo: %s".formatted(protocolNumber)));

    return ResponseMapper.mapToAssemblyResponse(entity);
  }

  public AssemblyResponse createAssembly(final AssemblyRequest assemblyRequest) {
    log.info("[ASSEMBLY-SERVICE] - Creating assembly...");
    final String protocolNumber = protocolService.buildProtocolNumber(SegmentEnum.ASSEMBLY);

    final AssemblyEntity assemblyEntity = AssemblyMapper.mapToAssemblyEntity(protocolNumber, assemblyRequest);
    final AssemblyEntity savedEntity = assemblyRepository.save(assemblyEntity);

    log.info("[ASSEMBLY-SERVICE] - Created assembly with protocol number: {}", savedEntity.getProtocolNumber());
    return ResponseMapper.mapToAssemblyResponse(savedEntity);
  }

  public List<List<AssemblyEventResponse>> getAssemblyEventsByProtocolNumber(final String protocolNumber) {
    final List<AssemblyEventEntity> entityEvents = assemblyEventRepository.findAllByProtocolNumber(protocolNumber);

    if (entityEvents.isEmpty()) {
      return Collections.emptyList();
    }

    final List<AssemblyEventResponse> informationEvents = entityEvents.stream()
            .filter(event -> AssemblyEventTypeEnum.INFORMATION.equals(event.getEventType()))
            .map(ResponseMapper::mapToAssemblyEventResponse)
            .toList();

    final List<AssemblyEventResponse> documentEvents = entityEvents.stream()
            .filter(event -> AssemblyEventTypeEnum.DOCUMENT.equals(event.getEventType()))
            .map(ResponseMapper::mapToAssemblyEventResponse)
            .toList();

    return Arrays.asList(informationEvents, documentEvents);
  }

  public AssemblyEventResponse createAssemblyEvent(final String protocolNumber, final AssemblyEventRequest assemblyEventRequest, final MultipartFile file) throws MissingInformationRequestException {
    if (Objects.nonNull(file)) {
      return this.createAssemblyDocumentEvent(protocolNumber, file, assemblyEventRequest);
    } else if (Objects.nonNull(assemblyEventRequest.getEvent())) {
      return this.createAssemblyInformationEvent(protocolNumber, assemblyEventRequest.getEvent(), assemblyEventRequest);
    }

    throw new MissingInformationRequestException("É preciso enviar pelo menos um evento");
  }

  private AssemblyEventResponse createAssemblyDocumentEvent(final String protocolNumber, final MultipartFile file, final AssemblyEventRequest request) {
    final FileEntity fileEntity;
    final String fileId;

    fileEntity = fileService.createFile(SegmentEnum.ASSEMBLY, TypeEnum.OTHER, protocolNumber, file);
    fileId = fileEntity.getId();

    final AssemblyEventEntity documentEventEntity = AssemblyMapper.mapToAssemblyEventEntity(protocolNumber, AssemblyEventTypeEnum.DOCUMENT, fileId, request);
    final AssemblyEventEntity savedDocumentEventEntity = assemblyEventRepository.save(documentEventEntity);

    return ResponseMapper.mapToAssemblyEventResponse(savedDocumentEventEntity);
  }

  private AssemblyEventResponse createAssemblyInformationEvent(final String protocolNumber, final String event, final AssemblyEventRequest request) {
    final AssemblyEventEntity informationEventEntity = AssemblyMapper.mapToAssemblyEventEntity(protocolNumber, AssemblyEventTypeEnum.INFORMATION, event, request);
    final AssemblyEventEntity savedInformationEventEntity = assemblyEventRepository.save(informationEventEntity);

    return ResponseMapper.mapToAssemblyEventResponse(savedInformationEventEntity);
  }

}
