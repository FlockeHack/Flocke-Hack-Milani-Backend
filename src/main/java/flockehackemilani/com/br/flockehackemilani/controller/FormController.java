package flockehackemilani.com.br.flockehackemilani.controller;

import flockehackemilani.com.br.flockehackemilani.model.request.AgcAccreditationRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.CreditDivergenceRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.CreditQualificationRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.AgcAccreditationResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.CreditDivergenceResponse;
import flockehackemilani.com.br.flockehackemilani.model.response.CreditQualificationResponse;
import flockehackemilani.com.br.flockehackemilani.service.FormService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/formularios")
@AllArgsConstructor
public class FormController {

  private final FormService formService;

  @PostMapping("/habilitacao-de-credito")
  public CreditQualificationResponse createCreditQualificationResponse(@RequestPart MultipartFile petition,
                                                                       @RequestPart MultipartFile powerOfAttorney,
                                                                       @RequestPart("attachment") List<MultipartFile> attachments,
                                                                       @Valid @RequestPart("metadata") CreditQualificationRequest creditQualificationRequest) throws IOException {
    return formService.createCreditQualificationForm(petition, powerOfAttorney, attachments, creditQualificationRequest);
  }

  @PostMapping("/credenciamento-agc")
  public AgcAccreditationResponse createAgcAccreditation(@Valid @RequestBody AgcAccreditationRequest agcAccreditationRequest) {
    return formService.createAgcAccreditationForm(agcAccreditationRequest);
  }

  @PostMapping("/divergencia-de-credito")
  public CreditDivergenceResponse createCreditDivergence(@RequestPart("petition") MultipartFile petition,
                                                        @RequestPart("powerOfAttorney") MultipartFile powerOfAttorney,
                                                        @RequestPart("attachment") List<MultipartFile> attachments,
                                                        @Valid @RequestPart("metadata") CreditDivergenceRequest creditDivergenceRequest) {
    return formService.createCreditDivergence(petition, powerOfAttorney, attachments, creditDivergenceRequest);
  }

}
