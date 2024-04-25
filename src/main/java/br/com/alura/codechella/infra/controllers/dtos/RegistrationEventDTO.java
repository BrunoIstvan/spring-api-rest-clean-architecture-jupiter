package br.com.alura.codechella.infra.controllers.dtos;

import br.com.alura.codechella.infra.persistence.event.CategoryEventEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistrationEventDTO(

        @NotNull(message = "A categoria do evento é obrigatória!")
        CategoryEventEnum categoryEventEnum,

        @NotBlank(message = "A descrição do evento é obrigatória!")
        String description,

        @NotNull(message = "O endereço do evento é obrigatório!")
        @Valid
        AddressDTO address,

        @NotNull(message = "Data do evento é obrigatória!")
        @Future(message = "Data do evento deve ser uma data futura!")
        LocalDateTime date,

        @NotNull(message = "Pelo menos um tipo de ingresso deve ser informado!")
        @Valid
        List<DadosCadastroTipoIngresso> tipoIngressos
) {
}
