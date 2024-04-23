package br.com.alura.codechella.domain.entity.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class UserFactory {

    private UserEntity userEntity;

    public UserEntity withCpfNameBirthdayEmail(String cpf, String name, LocalDate birthday, String email) {
        this.userEntity = new UserEntity(cpf, name, birthday, email, null);
        return this.userEntity;
    }

    public UserEntity withId(Long id) {
        this.userEntity.setId(id);
        return this.userEntity;
    }

    public UserEntity withAddress(String cep, Integer number, String complement) {
        this.userEntity.setAddress(new Address(cep, number, complement));
        return this.userEntity;
    }

}
