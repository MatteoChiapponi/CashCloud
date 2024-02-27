package com.mateo.notificationsms.bussiness.services.impl;

import com.mateo.notificationsms.bussiness.services.IMailSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class newUserRegistrationEmailSenderService implements IMailSenderService<MimeMultipart> {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, MimeMultipart content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            message.setContent(content);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
