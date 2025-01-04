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
public class JudicialEventResponse {

  private String id;
  private String titleName;
  private LocalDate date;
  private String protocolNumber;
  private String fileId;

}
