package flockehackemilani.com.br.flockehackemilani.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {

  @NotNull(message = "É preciso informar o nome para contato")
  private String name;
  @NotNull(message = "É preciso informar o email para contato")
  private String email;
  @NotNull(message = "É precios informar um número de telefone para contato")
  private String phone;
  private String city;
  private String uf;
  private String message;

}
