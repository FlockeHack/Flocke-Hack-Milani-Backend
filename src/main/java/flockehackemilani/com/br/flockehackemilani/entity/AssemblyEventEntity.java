package flockehackemilani.com.br.flockehackemilani.entity;

import flockehackemilani.com.br.flockehackemilani.enumeration.AssemblyEventTypeEnum;
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
@Document(collection = "assembly_events")
public class AssemblyEventEntity {

  @Id
  private String id;
  private String protocolNumber;

  private String eventName;
  private LocalDate eventDate;
  private String observation;
  private String event;

  private AssemblyEventTypeEnum eventType;

}
