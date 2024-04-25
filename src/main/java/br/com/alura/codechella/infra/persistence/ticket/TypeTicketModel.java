package br.com.alura.codechella.infra.persistence.ticket;

import br.com.alura.codechella.infra.persistence.event.SectorEventEnum;
import br.com.alura.codechella.infra.persistence.event.EventModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_ingresso")
public class TypeTicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private EventModel event;

    @Enumerated(EnumType.STRING)
    @Column(name = "setor")
    private SectorEventEnum sectorEvent;

    @Enumerated(EnumType.STRING)
    @Column(name = "definicao")
    private TypeCustomerTicketEnum definitionTicket;

    @Column(name = "valor")
    private Double value;

    @Column(name = "totalDisponivel")
    private int totalAvailable;

    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<TicketModel> tickets = new ArrayList<>();

    private TypeTicketModel() {}

    public TypeTicketModel(SectorEventEnum sectorEvent,
                           TypeCustomerTicketEnum definitionTicket,
                           Double value, int totalAvailable) {
        this.setSectorEvent(sectorEvent);
        this.setDefinitionTicket(definitionTicket);
        this.setValue(value);
        this.setTotalAvailable(totalAvailable);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventModel getEvent() {
        return event;
    }

    public void setEvent(EventModel event) {
        this.event = event;
    }

    public SectorEventModel getSectorEvent() {
        return sectorEvent;
    }

    public void setSectorEvent(SectorEventModel sectorEvent) {
        this.sectorEvent = sectorEvent;
    }

    public TypeCustomerTicketEnum getDefinitionTicket() {
        return definitionTicket;
    }

    public void setDefinitionTicket(TypeCustomerTicketEnum definitionTicket) {
        this.definitionTicket = definitionTicket;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public List<TicketModel> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketModel> tickets) {
        tickets.forEach(i -> i.setTypeTicket(this));
        this.tickets = tickets;
    }
}