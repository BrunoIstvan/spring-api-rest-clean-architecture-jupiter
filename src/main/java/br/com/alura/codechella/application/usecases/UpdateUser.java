package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.UserEntity;

public class UpdateUser {

    private final UserApplication application;

    public UpdateUser(UserApplication application) {
        this.application = application;
    }

    public UserEntity update(UserEntity userEntity) {
        return application.update(userEntity);
    }

}
