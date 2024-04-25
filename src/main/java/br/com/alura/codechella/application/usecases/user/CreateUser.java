package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.User;

public class CreateUser {

    private final UserApplication application;

    public CreateUser(UserApplication application) {
        this.application = application;
    }

    public User save(User user) {
        return application.save(user);
    }

}
