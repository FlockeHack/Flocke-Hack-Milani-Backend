package flockehackemilani.com.br.flockehackemilani.mapper;

import flockehackemilani.com.br.flockehackemilani.entity.ProtocolEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProtocolMapper {

  public ProtocolEntity mapToProtocolEntity(final String protocolNumber, final SegmentEnum segmentEnum, final String email) {
    return ProtocolEntity.builder()
            .protocolNumber(protocolNumber)
            .segment(segmentEnum)
            .email(email)
            .build();
  }

}
