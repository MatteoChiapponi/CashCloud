package com.mateo.notificationsms.bussiness.services.impl;

import com.mateo.notificationsms.dtos.NewUserInfo;
import com.mateo.notificationsms.bussiness.services.IMailSenderService;
import org.springframework.stereotype.Service;

@Service
public class newUserRegistrationEmailSenderService implements IMailSenderService<NewUserInfo> {

    //clases para enviar el email

    @Override
    public void sendEmail(NewUserInfo information) {

    }


}
