package com.mateo.notificationsms.bussiness.services;

public interface INotifyService <T> {
    void notify(T message);
}
