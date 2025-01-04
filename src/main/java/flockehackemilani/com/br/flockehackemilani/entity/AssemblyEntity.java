package flockehackemilani.com.br.flockehackemilani.entity;

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
@Document(collection = "assembly")
public class AssemblyEntity {

  @Id
  private String id;
  private String protocolNumber;
  private String name;
  private String processNumber;
  private String email;

}
