package com.practo.wp.utility;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class mailSendUtility {
  @Autowired
  private JavaMailSender javaMailService;

  public void send(String to, String subject, String body) throws MessagingException {

    MimeMessage message = javaMailService.createMimeMessage();
    MimeMessageHelper helper;

    helper = new MimeMessageHelper(message, true); // true indicates
    // multipart message
    helper.setSubject(subject);
    helper.setTo(to);
    helper.setText(body, true); // true indicates html
    // continue using helper object for more functionalities like adding attachments, etc.

    javaMailService.send(message);


  }
}
