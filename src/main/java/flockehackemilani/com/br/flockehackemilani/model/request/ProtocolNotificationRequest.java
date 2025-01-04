package flockehackemilani.com.br.flockehackemilani.model.request;

import flockehackemilani.com.br.flockehackemilani.enumeration.SegmentEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolNotificationRequest {

  private String protocolNumber;
  private String subject;
  private SegmentEnum segmentEnum;

}
