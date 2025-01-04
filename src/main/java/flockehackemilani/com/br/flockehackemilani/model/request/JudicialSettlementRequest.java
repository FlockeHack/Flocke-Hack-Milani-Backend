package flockehackemilani.com.br.flockehackemilani.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import flockehackemilani.com.br.flockehackemilani.enumeration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudicialSettlementRequest {

  private String name;
  private String relatedCompanies;
  private String cnpj;
  private String processNumber;
  private String county;
  private String court;
  private String judge;
  private String judicialAdministrator;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate orderDate;
  private StatusEnum status;

}
