package flockehackemilani.com.br.flockehackemilani.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditQualificationResponse {

  private String id;
  private String protocolNumber;
  private String creditorName;
  private String creditorEmail;
  private String cpf;
  private String cnpj;
  private BigDecimal creditValue;
  private String responsibleAttorney;
  private String debtor;
  private String debtorClass;
  private String message;
}
