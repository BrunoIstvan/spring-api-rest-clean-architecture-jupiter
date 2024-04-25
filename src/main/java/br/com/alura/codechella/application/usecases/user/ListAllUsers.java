package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.User;

import java.util.List;

public class ListAllUsers {

    private final UserApplication application;

    public ListAllUsers(UserApplication application) {
        this.application = application;
    }

    public List<User> list() { return application.listAll(); }

}
