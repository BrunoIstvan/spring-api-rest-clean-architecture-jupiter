package br.com.alura.codechella.infra.gateways.user;

import br.com.alura.codechella.domain.entity.user.User;
import br.com.alura.codechella.infra.persistence.user.UserModel;

public class UserMapper {

    public User toEntity(UserModel model) {
        return new User(model.getId(), model.getCpf(),
                model.getFullName(), model.getBirthday(), model.getEmail(),
                null);
    }

    public UserModel toModel(User entity) {
        return new UserModel(entity.getId(), entity.getCpf(),
                entity.getFullName(), entity.getBirthday(), entity.getEmail());
    }

}
