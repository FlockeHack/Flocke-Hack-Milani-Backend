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
@Document(collection = "contact")
public class ContactEntity {

  @Id
  private String id;
  private String name;
  private String email;
  private String phone;
  private String city;
  private String uf;
  private String message;

}
