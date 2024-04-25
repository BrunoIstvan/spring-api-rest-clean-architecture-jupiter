package br.com.alura.codechella.domain.entity.ticket;

import br.com.alura.codechella.infra.persistence.event.SectorEventEnum;
import br.com.alura.codechella.infra.persistence.ticket.TypeCustomerTicketEnum;

public class TypeTicket {

    private Long id;

    private Long eventId;

    private SectorEventEnum sector;

    private TypeCustomerTicketEnum typeCustomerTicket;

    private Double value;

    private int totalAvailable;

    public TypeTicket(Long id, Long eventId, SectorEventEnum sector, TypeCustomerTicketEnum typeCustomerTicket, Double value, int totalAvailable) {
        this.id = id;
        this.eventId = eventId;
        this.sector = sector;
        this.typeCustomerTicket = typeCustomerTicket;
        this.value = value;
        this.totalAvailable = totalAvailable;
    }



}
