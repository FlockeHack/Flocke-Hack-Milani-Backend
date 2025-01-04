package flockehackemilani.com.br.flockehackemilani.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import flockehackemilani.com.br.flockehackemilani.enumeration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudicialBankruptcyRequest {

  private String name;
  private String location;
  private String relatedCompanies;
  private String cnpj;
  private String processNumber;
  private String county;
  private String court;
  private String judge;
  private String judicialAdministrator;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate orderDate;
  private String assemblyProtocolNumber;
  private StatusEnum status;

}
