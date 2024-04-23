package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.UserEntity;

public class CreateUser {

    private final UserApplication application;

    public CreateUser(UserApplication application) {
        this.application = application;
    }

    public UserEntity save(UserEntity userEntity) {
        return application.save(userEntity);
    }

}
