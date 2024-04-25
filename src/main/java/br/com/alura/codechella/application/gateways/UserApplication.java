package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entity.user.User;

import java.util.List;

public interface UserApplication {

    User save(User user);

    User update(User user);

    void delete(Long id);

    User getById(Long id);

    List<User> listAll();

}
