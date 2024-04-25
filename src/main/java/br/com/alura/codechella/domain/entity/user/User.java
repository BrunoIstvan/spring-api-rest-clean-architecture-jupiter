package br.com.alura.codechella.domain.entity.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class User {

    private Long id;
    private String cpf;
    private String fullName;
    private LocalDate birthday;
    private String email;

    private Address address;

    private void validateName(String name) {
        if(name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name has invalid value");
        }
    }

    private void validateBirthday(LocalDate birthday) {
        if(birthday == null || !birthday.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Birthday has invalid value");
        }

    }

    private void validateEmail(String email) {
        var regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if(email == null || !email.trim().matches(regexPattern)) {
            throw new IllegalArgumentException("Email has invalid value");
        }
    }

    private void validateCpf(String cpf) {
        if(cpf == null || !cpf.trim().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            throw new IllegalArgumentException("CPF has invalid value");
        }
    }

    public User(String cpf, String fullName, LocalDate birthday, String email, Address address) {
        validateCpf(cpf);
        validateName(fullName);
        validateEmail(email);
        validateBirthday(birthday);
        this.setCpf(cpf.trim());
        this.setFullName(fullName.trim());
        this.setBirthday(birthday);
        this.setEmail(email.trim());
        this.setAddress(address);

    }

    public User(Long id, String cpf, String fullName, LocalDate birthday, String email, Address address) {
        validateCpf(cpf);
        validateName(fullName);
        validateBirthday(birthday);
        validateEmail(email);
        this.setId(id);
        this.setCpf(cpf.trim());
        this.setFullName(fullName.trim());
        this.setBirthday(birthday);
        this.setEmail(email.trim());
        this.setAddress(address);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
