package com.practo.wp.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailSenderUtility {
  @Autowired
  private JavaMailSender javaMailService;

  /**
   * Send mail to the registering user.
   * 
   * @param to email id of the registering user
   * @param subject trip Name and date
   * @param body contains trip name, date, id, poster deatils
   * @throws MessagingException ()
   */
  public void send(String to, String subject, String body) throws MessagingException {

    MimeMessage message = javaMailService.createMimeMessage();
    MimeMessageHelper helper;
    helper = new MimeMessageHelper(message, true);
    helper.setSubject(subject);
    helper.setTo(to);
    helper.setText(body, true);
    javaMailService.send(message);

  }
}
