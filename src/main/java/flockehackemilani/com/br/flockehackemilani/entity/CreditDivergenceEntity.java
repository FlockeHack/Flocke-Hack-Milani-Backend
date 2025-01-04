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
@Document(collection = "credit_divergence")
public class CreditDivergenceEntity {

  @Id
  private String id;
  private String protocolNumber;

  private String creditorName;
  private String creditorEmail;
  private String creditorPhone;
  private String cpf;
  private String cnpj;
  private BigDecimal creditValue;
  private String responsibleAttorney;

  private String debtor;
  private String debtorClass;

  private String message;

}
