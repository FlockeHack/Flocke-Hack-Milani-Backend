package flockehackemilani.com.br.flockehackemilani.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactResponse {

  private String id;
  private String name;
  private String email;
  private String phone;
  private String city;
  private String uf;
  private String message;

}
