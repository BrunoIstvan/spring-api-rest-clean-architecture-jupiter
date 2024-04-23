package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entity.user.UserEntity;

import java.util.List;

public interface UserApplication {

    UserEntity save(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    void delete(Long id);

    UserEntity getById(Long id);

    List<UserEntity> listAll();

}
