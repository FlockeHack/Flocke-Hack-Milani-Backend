package flockehackemilani.com.br.flockehackemilani.controller;

import flockehackemilani.com.br.flockehackemilani.model.request.ContactRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.ProtocolNotificationRequest;
import flockehackemilani.com.br.flockehackemilani.service.NotificationService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/notificacao")
@AllArgsConstructor
public class NotificationController {

  private final NotificationService notificationService;

  @PostMapping("/protocolo-com-anexo")
  public void notifyCreatedProtocolWithAttachments(@RequestPart("request") ProtocolNotificationRequest request, @RequestPart("attachment") List<MultipartFile> attachments) throws MessagingException {
    notificationService.sendEmailWithAttachments(request, attachments);
  }

  @PostMapping("/contato")
  public void notifyCreatedContactRequest(@Valid @RequestBody ContactRequest contactRequest) throws MessagingException {
    notificationService.notifyCreatedContact(contactRequest);
  }

}
