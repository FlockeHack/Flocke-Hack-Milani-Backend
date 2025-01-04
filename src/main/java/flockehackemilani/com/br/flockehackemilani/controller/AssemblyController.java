package flockehackemilani.com.br.flockehackemilani.controller;

import flockehackemilani.com.br.flockehackemilani.exceptions.MissingInformationRequestException;
import flockehackemilani.com.br.flockehackemilani.exceptions.ResourceNotFoundException;
import flockehackemilani.com.br.flockehackemilani.model.request.AssemblyEventRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.AssemblyRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.AssemblyEventResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.AssemblyResponse;
import flockehackemilani.com.br.flockehackemilani.service.AssemblyService;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/assembleias")
@AllArgsConstructor
public class AssemblyController {

  private final AssemblyService assemblyService;

  @GetMapping()
  public List<AssemblyResponse> getAllAssemblies() {
    return assemblyService.getAllAssemblies();
  }

  @GetMapping("/{protocolNumber}")
  public AssemblyResponse getAssemblyByProtocolNumber(@PathVariable final String protocolNumber) throws ResourceNotFoundException {
    return assemblyService.getAssemblyByProtocolNumber(protocolNumber);
  }

  @PostMapping()
  public AssemblyResponse createAssembly(@RequestBody final AssemblyRequest assemblyRequest) {
    return assemblyService.createAssembly(assemblyRequest);
  }

  @GetMapping("/{protocolNumber}/eventos")
  public List<List<AssemblyEventResponse>> getAssemblyEvents(@PathVariable final String protocolNumber) {
    return assemblyService.getAssemblyEventsByProtocolNumber(protocolNumber);
  }

  @PostMapping("/{protocolNumber}/eventos")
  public AssemblyEventResponse createAssemblyEvent(@PathVariable final String protocolNumber,
                                                   @RequestPart("metadata") final AssemblyEventRequest eventRequest,
                                                   @RequestPart("file") @Nullable MultipartFile file) throws MissingInformationRequestException {
    return assemblyService.createAssemblyEvent(protocolNumber, eventRequest, file);
  }

}
