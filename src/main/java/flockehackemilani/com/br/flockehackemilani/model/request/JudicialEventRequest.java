package flockehackemilani.com.br.flockehackemilani.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudicialEventRequest {

  @NotNull(message = "Nome do evento é obrigatorio.")
  private String titleName;
  @NotNull(message = "Data do evento é obrigatória.")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate eventDate;
  @NotNull(message = "Numero de protocolo é obrigatorio.")
  private String protocolNumber;

}
