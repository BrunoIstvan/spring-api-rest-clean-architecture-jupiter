package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserApplication;

public class DeleteUser {

    private final UserApplication application;

    public DeleteUser(UserApplication application) {
        this.application = application;
    }

    public void delete(Long id) {
        application.delete(id);
    }

}
