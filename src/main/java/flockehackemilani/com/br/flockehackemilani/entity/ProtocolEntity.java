package flockehackemilani.com.br.flockehackemilani.entity;

import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "protocol")
public class ProtocolEntity {

  @Id
  private String id;
  private String protocolNumber;
  private SegmentEnum segment;
  private String email;

}
