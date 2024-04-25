package br.com.alura.codechella.infra.controllers.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegistrationSaleDTO(

        @NotNull(message = "O id do usuário é obrigatório!")
        Long userId,

        @NotNull(message = "Os dados do ingresso devem ser informados")
        @Valid
        List<RegistrationTicketDTO> tickets

) {

}