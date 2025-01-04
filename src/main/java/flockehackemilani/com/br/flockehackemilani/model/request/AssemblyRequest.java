package flockehackemilani.com.br.flockehackemilani.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssemblyRequest {

  private String processNumber;
  private String name;
  private String email;

}
