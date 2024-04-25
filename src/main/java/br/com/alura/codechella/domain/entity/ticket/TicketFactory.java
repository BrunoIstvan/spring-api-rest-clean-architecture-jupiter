package br.com.alura.codechella.domain.entity.ticket;

import br.com.alura.codechella.infra.persistence.event.SectorEventEnum;

public class TicketFactory {

    private Ticket ticket;

    public Ticket create(Long id, int code, SectorEventEnum sector, Long saleId) {
        ticket = new Ticket(id, code, sector, saleId);
        return ticket;
    }

}
