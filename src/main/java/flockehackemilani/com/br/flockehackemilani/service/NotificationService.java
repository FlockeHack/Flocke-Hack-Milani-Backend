package flockehackemilani.com.br.flockehackemilani.service;

import flockehackemilani.com.br.flockehackemilani.model.request.ContactRequest;
import flockehackemilani.com.br.flockehackemilani.model.request.ProtocolNotificationRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NotificationService {

  private final JavaMailSender emailSender;
  private final ProtocolService protocolService;

  @Autowired
  private final SpringTemplateEngine templateEngine;

  public void sendEmailWithAttachments(final ProtocolNotificationRequest notificationRequest, final List<MultipartFile> files) throws MessagingException {
    final String subject = notificationRequest.getSubject();

    final MimeMessage mimeMessage = emailSender.createMimeMessage();
    final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

    final Context context = new Context();
    context.setVariable("segment", notificationRequest.getSegmentEnum().getSegment());
    context.setVariable("protocolNumber", notificationRequest.getProtocolNumber());
    final String htmlContent = templateEngine.process("email-with-attachments-template.html", context);

    String[] to = new String[1];
    to[0] = "otavioschein@sou.faccat.br";

    mimeMessageHelper.setFrom("otaviomschein@gmail.com");
    mimeMessageHelper.setTo(to);
    mimeMessageHelper.setSubject(subject);
    mimeMessageHelper.setText(htmlContent, true);
    mimeMessageHelper.addInline("logo", new ClassPathResource("assets/logo.png"));

    for (MultipartFile file : files) {
      if (Objects.nonNull(file) && Objects.nonNull(file.getOriginalFilename())) {
        mimeMessageHelper.addAttachment(file.getOriginalFilename(), file);
      }
    }

    emailSender.send(mimeMessage);
  }

  public void notifyCreatedContact(final ContactRequest contactRequest) throws MessagingException {
    final String subject = "Requisição de contato para %s".formatted(contactRequest.getName());

    final MimeMessage mimeMessage = emailSender.createMimeMessage();
    final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

    final Context context = getContactContext(contactRequest);
    final String htmlContent = templateEngine.process("email-contact-request-template.html", context);

    String[] to = new String[1];
    to[0] = "otavioschein@sou.faccat.br";

    mimeMessageHelper.setFrom("otaviomschein@gmail.com");
    mimeMessageHelper.setTo(to);
    mimeMessageHelper.setSubject(subject);
    mimeMessageHelper.setText(htmlContent, true);
    mimeMessageHelper.addInline("logo", new ClassPathResource("assets/logo.png"));

    emailSender.send(mimeMessage);
  }

  private Context getContactContext(final ContactRequest contactRequest) {
    final Context context = new Context();
    context.setVariable("name", contactRequest.getName());
    context.setVariable("email", contactRequest.getEmail());
    context.setVariable("phone", contactRequest.getPhone());
    context.setVariable("city", Optional.ofNullable(contactRequest.getCity()).orElse("Não foi informado a cidade."));
    context.setVariable("uf", Optional.ofNullable(contactRequest.getUf()).orElse("Não foi informado o UF."));
    context.setVariable("message", Optional.ofNullable(contactRequest.getMessage()).orElse("Não foi informado nenhuma mensagem."));
    return context;
  }

}
