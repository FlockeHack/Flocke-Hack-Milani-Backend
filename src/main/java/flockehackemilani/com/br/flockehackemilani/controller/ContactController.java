package flockehackemilani.com.br.flockehackemilani.controller;

import flockehackemilani.com.br.flockehackemilani.model.request.ContactRequest;
import flockehackemilani.com.br.flockehackemilani.model.response.ContactResponse;
import flockehackemilani.com.br.flockehackemilani.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/contato")
@AllArgsConstructor
public class ContactController {

  private final ContactService contactService;

  @PostMapping
  public ContactResponse createContact(@Valid @RequestBody ContactRequest contactRequest) {
    return contactService.createContact(contactRequest);
  }

}
