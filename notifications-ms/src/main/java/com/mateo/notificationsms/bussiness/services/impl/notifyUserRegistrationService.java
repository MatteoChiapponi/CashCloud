package com.mateo.notificationsms.bussiness.services.impl;

import com.mateo.notificationsms.bussiness.services.IMailSenderService;
import com.mateo.notificationsms.bussiness.services.INotifyService;
import com.mateo.notificationsms.dtos.UserEmailDataDto;
import jakarta.mail.internet.MimeMultipart;

public class notifyUserRegistrationService implements INotifyService<UserEmailDataDto> {

    IMailSenderService<MimeMultipart> mailSenderService;
    @Override
    public void notify(UserEmailDataDto message) {
        MimeMultipart content = new MimeMultipart("related");
        //generar estilo del email
        mailSenderService.sendEmail(message.email(), "¡Successfully registered!",content);
    }
}
