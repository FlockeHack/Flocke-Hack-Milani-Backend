package flockehackemilani.com.br.flockehackemilani.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "agc_accreditation")
public class AgcAccreditationEntity {

  @Id
  private String id;
  private String protocolNumber;
  private String assemblyProtocolNumber;
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
