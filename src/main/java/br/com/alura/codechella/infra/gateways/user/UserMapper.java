package br.com.alura.codechella.infra.gateways.user;

import br.com.alura.codechella.domain.entity.user.UserEntity;
import br.com.alura.codechella.infra.persistence.user.UserModel;

public class UserMapper {

    public UserEntity toEntity(UserModel model) {
        return new UserEntity(model.getId(), model.getCpf(),
                model.getNome(), model.getNascimento(), model.getEmail(),
                null);
    }

    public UserModel toModel(UserEntity entity) {
        return new UserModel(entity.getId(), entity.getCpf(),
                entity.getFullName(), entity.getBirthday(), entity.getEmail());
    }

}
