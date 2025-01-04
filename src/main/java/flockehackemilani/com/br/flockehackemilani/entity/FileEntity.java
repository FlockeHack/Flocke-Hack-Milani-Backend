package flockehackemilani.com.br.flockehackemilani.entity;

import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import flockehackemilani.com.br.flockehackemilani.enumeration.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "file")
public class FileEntity {

  @Id
  private String id;
  private String protocolNumber;
  private String name;
  private byte[] data;
  private SegmentEnum segment;
  private TypeEnum type;
}
