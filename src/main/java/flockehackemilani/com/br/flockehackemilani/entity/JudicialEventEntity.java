package flockehackemilani.com.br.flockehackemilani.entity;

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
@Document(collection = "judicial_event")
public class JudicialEventEntity {

  @Id
  private String id;
  private String protocolNumber;
  private String titleName;
  private LocalDate date;
  private String fileId;

}
