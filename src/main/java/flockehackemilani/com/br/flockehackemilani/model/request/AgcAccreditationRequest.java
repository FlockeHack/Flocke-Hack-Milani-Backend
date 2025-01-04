package flockehackemilani.com.br.flockehackemilani.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgcAccreditationRequest {

  private String assemblyProtocolNumber;
  private String assembly;
  private String creditorName;
  private String cpf;
  private String cnpj;
  private BigDecimal creditValue;
  private String creditorClass;
  @NotNull(message = "É preciso informar um nome")
  private String representativeName;
  @NotNull(message = "É preciso informar um número de telefone")
  private String representativePhone;
  @NotNull(message = "É preciso informar um email")
  private String representativeEmail;
}
