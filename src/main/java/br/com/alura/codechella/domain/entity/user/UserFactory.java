package br.com.alura.codechella.domain.entity.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class UserFactory {

    private User user;

    public User withCpfNameBirthdayEmail(String cpf, String name, LocalDate birthday, String email) {
        this.user = new User(cpf, name, birthday, email, null);
        return this.user;
    }

    public User withId(Long id) {
        this.user.setId(id);
        return this.user;
    }

    public User withAddress(String cep, Integer number, String complement) {
        this.user.setAddress(new Address(cep, number, complement));
        return this.user;
    }

}
