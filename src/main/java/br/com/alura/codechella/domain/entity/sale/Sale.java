package br.com.alura.codechella.domain.entity.sale;

import br.com.alura.codechella.domain.entity.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private Long id;

    private Long userId;

    private List<Ticket> tickets = new ArrayList<>();

    public Sale(Long id, Long userId, List<Ticket> tickets) {
        this.setId(id);
        this.setUserId(userId);
        this.setTickets(tickets);
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
