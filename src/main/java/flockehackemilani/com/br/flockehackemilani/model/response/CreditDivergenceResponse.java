package flockehackemilani.com.br.flockehackemilani.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditDivergenceResponse {

  private String id;
  private String protocolNumber;
  private String creditorName;
  private String creditorEmail;
  private String creditorPhone;
}
