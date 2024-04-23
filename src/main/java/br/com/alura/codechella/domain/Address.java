package br.com.alura.codechella.domain;

import java.util.Objects;

public class Address {

    private String cep;

    private Integer number;

    private String complement;

    public Address(String cep, Integer number, String complement) {
        this.setCep(cep);
        this.setNumber(number);
        this.setComplement(complement);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(cep, address.cep) && Objects.equals(number, address.number) && Objects.equals(complement, address.complement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, number, complement);
    }
}
