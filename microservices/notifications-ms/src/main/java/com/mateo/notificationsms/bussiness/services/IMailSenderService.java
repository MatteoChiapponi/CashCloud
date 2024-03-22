package com.mateo.notificationsms.bussiness.services;

public interface IMailSenderService<T> {

    void sendEmail(String to, String subject,T content);
}
