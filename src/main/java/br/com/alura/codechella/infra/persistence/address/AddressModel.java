package br.com.alura.codechella.infra.persistence.address;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AddressModel {
    private String cep;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "complemento")
    private String complement;

    public AddressModel() {}

    public AddressModel(String cep, Integer number, String complement) {
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
}