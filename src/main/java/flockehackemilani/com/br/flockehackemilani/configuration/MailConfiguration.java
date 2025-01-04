package flockehackemilani.com.br.flockehackemilani.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {

  @Bean
  public JavaMailSender getJavaMailSender() {
    final JavaMailSenderImpl  mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername("otaviomschein@gmail.com");
    mailSender.setPassword("wflx baji telt jebr");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.debug", "true");

    return mailSender;
  }

}
