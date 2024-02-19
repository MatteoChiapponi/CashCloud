package com.mateo.notificationsms.bussiness.services;

public interface IMailSenderService<T> {

    void sendEmail(T information);
}
