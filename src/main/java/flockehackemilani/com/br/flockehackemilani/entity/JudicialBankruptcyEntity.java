package flockehackemilani.com.br.flockehackemilani.entity;

import flockehackemilani.com.br.flockehackemilani.enumeration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "judicial_bankruptcy")
public class JudicialBankruptcyEntity {

  @Id
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
  private String assemblyProtocolNumber;
  private StatusEnum status;

}
