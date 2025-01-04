package flockehackemilani.com.br.flockehackemilani.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDivergenceRequest {

  @NotNull(message = "É preciso informar um nome")
  private String creditorName;
  @NotNull(message = "É preciso informar um email")
  private String creditorEmail;
  @NotNull(message = "É preciso informar um telefone")
  private String creditorPhone;
  private String cpf;
  private String cnpj;
  @NotNull(message = "É preciso informar um valor")
  private BigDecimal creditValue;
  private String responsibleAttorney;

  private String debtor;
  private String debtorClass;

  private String message;

}
