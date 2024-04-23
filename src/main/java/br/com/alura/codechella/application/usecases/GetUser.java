package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.UserEntity;

public class GetUser {

    private final UserApplication application;

    public GetUser(UserApplication application) {
        this.application = application;
    }

    public UserEntity getById(Long id) { return application.getById(id); }

}
