package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.User;

public class UpdateUser {

    private final UserApplication application;

    public UpdateUser(UserApplication application) {
        this.application = application;
    }

    public User update(User user) {
        return application.update(user);
    }

}
