package br.com.alura.codechella.domain.entity.sale;

import br.com.alura.codechella.domain.entity.ticket.Ticket;

import java.util.List;

public class SaleFactory {

    private Sale sale;

    public Sale createIdUserTickets(Long id, Long userId, List<Ticket> tickets) {
        this.sale = new Sale(id, userId, tickets);
        return this.sale;
    }

}
