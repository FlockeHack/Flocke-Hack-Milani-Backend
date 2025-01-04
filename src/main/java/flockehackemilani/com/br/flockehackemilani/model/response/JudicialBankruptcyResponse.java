package flockehackemilani.com.br.flockehackemilani.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JudicialBankruptcyResponse {

  private String id;
  private String protocolNumber;
  private String name;
  private String location;
  private String relatedCompanies;
  private String cnpj;
  private String processNumber;
  private String county;
  private String court;
  private String judge;
  private String judicialAdministrator;
  private LocalDate updateDate;
  private LocalDate orderDate;
  private LocalDate closedDate;
  private String assemblyId;
  private String status;

}
