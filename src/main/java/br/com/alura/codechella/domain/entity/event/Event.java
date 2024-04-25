package br.com.alura.codechella.domain.entity.event;

import br.com.alura.codechella.domain.Address;
import br.com.alura.codechella.domain.entity.ticket.TypeTicket;
import br.com.alura.codechella.infra.persistence.event.CategoryEventEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private Long id;

    private CategoryEventEnum category;

    private String description;

    private Address address;

    private LocalDateTime date;

    private final List<TypeTicket> typesTicket = new ArrayList<>();

    public void includeTypeTicketToTheEvent(TypeTicket typeTicket) {
        typesTicket.add(typeTicket);
    }

    public void increaseTotalTicketsByType() throws NoSuchMethodException {
        // not implemented
        throw new NoSuchMethodException();
    }

    public Long getId() {
        return id;
    }

    public CategoryEventEnum getTypeEvent() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<TypeTicket> getTypesTicket() {
        return typesTicket;
    }
}
