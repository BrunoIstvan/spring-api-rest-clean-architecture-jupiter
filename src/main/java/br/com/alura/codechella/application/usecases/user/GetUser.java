package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.User;

public class GetUser {

    private final UserApplication application;

    public GetUser(UserApplication application) {
        this.application = application;
    }

    public User getById(Long id) { return application.getById(id); }

}
