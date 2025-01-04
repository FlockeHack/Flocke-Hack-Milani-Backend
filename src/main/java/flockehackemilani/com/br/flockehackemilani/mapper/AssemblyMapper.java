package flockehackemilani.com.br.flockehackemilani.mapper;

import flockehackemilani.com.br.flockehackemilani.entity.AssemblyEntity;
import flockehackemilani.com.br.flockehackemilani.entity.AssemblyEventEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.AssemblyEventTypeEnum;
import flockehackemilani.com.br.flockehackemilani.model.request.AssemblyEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.AssemblyRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AssemblyMapper {

  public AssemblyEntity mapToAssemblyEntity(final String protocolNumber, final AssemblyRequest request) {
    return AssemblyEntity.builder()
            .protocolNumber(protocolNumber)
            .name(request.getName())
            .email(request.getEmail())
            .processNumber(request.getProcessNumber())
            .build();
  }

  public AssemblyEventEntity mapToAssemblyEventEntity(final String protocolNumber, final AssemblyEventTypeEnum eventTypeEnum, final String event, final AssemblyEventRequest request) {
    return AssemblyEventEntity.builder()
            .protocolNumber(protocolNumber)
            .eventName(request.getEventName())
            .eventDate(request.getEventDate())
            .observation(request.getObservation())
            .event(event)
            .eventType(eventTypeEnum)
            .build();
  }

}
