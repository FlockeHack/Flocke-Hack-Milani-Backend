package flockehackemilani.com.br.flockehackemilani.controller;

import flockehackemilani.com.br.flockehackemilani.model.request.JudicialEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialRecoveryRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialEventResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialRecoveryResponse;
import flockehackemilani.com.br.flockehackemilani.service.JudicialRecoveryService;
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
@RequestMapping("/v1/recuperacoes-judiciais")
@AllArgsConstructor
public class JudicialRecoveryController {

  private final JudicialRecoveryService judicialRecoveryService;

  @GetMapping()
  public List<JudicialRecoveryResponse> getAllJudicialRecovery() {
    return judicialRecoveryService.getAllJudicialRecovery();
  }

  @GetMapping("/{id}")
  public JudicialRecoveryResponse getJudicialRecoveryById(@PathVariable final String id) {
    return judicialRecoveryService.getJudicialRecoveryById(id);
  }

  @PostMapping()
  public JudicialRecoveryResponse createJudicialRecovery(@RequestBody final JudicialRecoveryRequest request) {
    return judicialRecoveryService.createJudicialRecovery(request);
  }

  @GetMapping("/eventos/{protocolNumber}")
  public List<JudicialEventResponse> getAllEventsByProtocolNumber(@PathVariable final String protocolNumber) {
    return judicialRecoveryService.getAllJudicialEventByProtocolNumber(protocolNumber);
  }

  @PostMapping("/eventos")
  public JudicialEventResponse createJudicialEvent(@Valid @RequestPart("request") JudicialEventRequest request,
                                                   @RequestPart("file") MultipartFile file) {
    return judicialRecoveryService.createJudicialEvent(request, file);
  }

}
