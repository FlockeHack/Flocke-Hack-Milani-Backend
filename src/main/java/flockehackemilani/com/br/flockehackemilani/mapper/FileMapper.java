package flockehackemilani.com.br.flockehackemilani.mapper;

import flockehackemilani.com.br.flockehackemilani.entity.FileEntity;
import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.TypeEnum;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FileMapper {

  public FileEntity mapToFileEntity(final SegmentEnum segmentEnum, final TypeEnum typeEnum, final String protocolNumber, final String fileName, final byte[] data) {
    return FileEntity.builder()
            .protocolNumber(protocolNumber)
            .name(fileName)
            .data(data)
            .segment(segmentEnum)
            .type(typeEnum)
            .build();
  }

}
