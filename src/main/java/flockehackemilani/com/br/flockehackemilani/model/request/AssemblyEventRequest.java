package flockehackemilani.com.br.flockehackemilani.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import flockehackemilani.com.br.flockehackemilani.enumeration.AssemblyEventTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssemblyEventRequest {

  private String eventName;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate eventDate;
  private String observation;
  private AssemblyEventTypeEnum eventType;
  private String event;

}
