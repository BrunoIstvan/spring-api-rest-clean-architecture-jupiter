package br.com.alura.codechella.infra.controllers.dtos;

import br.com.alura.codechella.domain.entity.ticket.TypeTicket;
import jakarta.validation.constraints.NotNull;

public record RegistrationTicketDTO(

        @NotNull(message = "O código do ingresso é obrigatório!")
        Integer code,

        @NotNull(message = "O id do tipo é obrigatório!")
        Long typeTicketId
) {

        public static RegistrationTicketDTO toDTO(TypeTicket entity) {
                return null;
        }

        public static TypeTicket toEntity(RegistrationTicketDTO dto) {
                var entity = new TypeTicket();
                ent
        }

}
