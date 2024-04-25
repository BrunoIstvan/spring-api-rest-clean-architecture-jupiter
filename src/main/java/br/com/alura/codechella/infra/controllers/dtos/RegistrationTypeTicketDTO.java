package br.com.alura.codechella.infra.controllers.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RegistrationTypeTicketDTO(
        @NotNull(message = "O formato do ingresso é obrigatório!")
        Formato formato,
        @NotNull(message = "A definição do tipo de ingresso é obrigatória!")
        Definicao definicao,
        @NotNull
        Double valor,
        @Positive
        int totalDisponivel

) {
}