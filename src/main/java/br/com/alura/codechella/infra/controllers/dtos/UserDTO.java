package br.com.alura.codechella.infra.controllers.dtos;

import br.com.alura.codechella.domain.entity.user.User;
import br.com.alura.codechella.domain.entity.user.UserFactory;

import java.time.LocalDate;

public record UserDTO(
        Long id,
        String cpf,
        String name,
        LocalDate birthday,
        String email
) {

    public static User toEntity(UserDTO dto) {
        var factory = new UserFactory();
        var entity = factory.withCpfNameBirthdayEmail(dto.cpf, dto.name, dto.birthday, dto.email);
        if(dto.id != null) {
            entity.setId(dto.id);
        }
        return entity;
    }
    public static UserDTO toDTO(User entity) {
        return new UserDTO(entity.getId(), entity.getCpf(),
                entity.getFullName(), entity.getBirthday(), entity.getEmail());
    }
}
