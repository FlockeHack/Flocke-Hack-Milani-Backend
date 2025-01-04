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
public class AssemblyEventResponse {

  private String id;
  private String protocolNumber;
  private String eventName;
  private LocalDate eventDate;
  private String observation;
  private String event;
  private String eventType;

}
