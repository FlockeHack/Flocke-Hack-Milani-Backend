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
public class AgcAccreditationResponse {

  private String id;
  private String protocolNumber;

  private String assembly;
  private String creditorName;
  private String cpf;
  private String cnpj;
  private BigDecimal creditValue;
  private String creditorClass;
  private String representativeName;
  private String representativePhone;
  private String representativeEmail;
}
