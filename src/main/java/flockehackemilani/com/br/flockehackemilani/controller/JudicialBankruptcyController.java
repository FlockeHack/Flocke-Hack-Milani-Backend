package flockehackemilani.com.br.flockehackemilani.controller;

import flockehackemilani.com.br.flockehackemilani.exceptions.ResourceNotFoundException;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialBankruptcyRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.JudicialEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialBankruptcyResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.JudicialEventResponse;
import flockehackemilani.com.br.flockehackemilani.service.JudicialBankruptcyService;
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
@RequestMapping("/v1/falencias")
@AllArgsConstructor
public class JudicialBankruptcyController {

  private final JudicialBankruptcyService judicialBankruptcyService;

  @GetMapping()
  public List<JudicialBankruptcyResponse> getAllJudicialBankruptcy() {
    return judicialBankruptcyService.getAllJudicialBankruptcy();
  }

  @GetMapping("/{id}")
  public JudicialBankruptcyResponse getJudicialBankruptcyById(@PathVariable final String id) throws ResourceNotFoundException {
    return judicialBankruptcyService.getJudicialBankruptcyById(id);
  }

  @PostMapping()
  public JudicialBankruptcyResponse createJudicialBankruptcy(@RequestBody final JudicialBankruptcyRequest request) {
    return judicialBankruptcyService.createJudicialBankruptcy(request);
  }

  @GetMapping("/eventos/{protocolNumber}")
  public List<JudicialEventResponse> getAllEventsByProtocolNumber(@PathVariable final String protocolNumber) {
    return judicialBankruptcyService.getAllJudicialEventByProcessNumber(protocolNumber);
  }

  @PostMapping("/eventos")
  public JudicialEventResponse createJudicialEvent(@Valid @RequestPart("request") JudicialEventRequest request,
                                                   @RequestPart("file") MultipartFile file) {
    return judicialBankruptcyService.createJudicialEvent(request, file);
  }
}
