package flockehackemilani.com.br.flockehackemilani.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssemblyResponse {

  @Id
  private String id;
  private String protocolNumber;
  private String name;
  private String processNumber;
  private String email;

}
