package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;
import br.com.alura.codechella.domain.entity.user.UserEntity;

import java.util.List;

public class ListAllUsers {

    private final UserApplication application;

    public ListAllUsers(UserApplication application) {
        this.application = application;
    }

    public List<UserEntity> list() { return application.listAll(); }

}
