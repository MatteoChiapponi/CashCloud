package com.mateo.usersms.bussiness.services.users;

public interface IUserValidationService {
    boolean isAliasAvailable(String alias);
    boolean isCvuAvailable(String cvu);
    boolean isEmailAvailable(String email);

}
