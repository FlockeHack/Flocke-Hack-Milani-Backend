package flockehackemilani.com.br.flockehackemilani.controller;

import flockehackemilani.com.br.flockehackemilani.model.request.JudicialEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialSettlementRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialEventResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialSettlementResponse;
import flockehackemilani.com.br.flockehackemilani.service.JudicialSettlementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/liquidacoes")
@AllArgsConstructor
public class JudicialSettlementController {

  private final JudicialSettlementService judicialSettlementService;

  @GetMapping()
  public List<JudicialSettlementResponse> getAllJudicialSettlement() {
    return judicialSettlementService.getAllJudicialSettlement();
  }

  @GetMapping("/{id}")
  public JudicialSettlementResponse getJudicialSettlementById(@PathVariable final String id) {
    return judicialSettlementService.getJudicialSettlementById(id);
  }

  @PostMapping
  public JudicialSettlementResponse createJudicialSettlement(@RequestBody final JudicialSettlementRequest request) {
    return judicialSettlementService.createJudicialSettlement(request);
  }

  @GetMapping("/eventos/{protocolNumber}")
  public List<JudicialEventResponse> getAllEventsByProtocolNumber(@PathVariable final String protocolNumber) {
    return judicialSettlementService.getAllJudicialEventByProcessNumber(protocolNumber);
  }

  @PostMapping("/eventos")
  public JudicialEventResponse createJudicialEvent(@Valid @RequestPart("request") JudicialEventRequest request,
                                                   @RequestPart("file") MultipartFile file) {
    return judicialSettlementService.createJudicialEvent(request, file);
  }

}
