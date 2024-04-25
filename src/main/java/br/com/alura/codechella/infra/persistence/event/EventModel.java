package br.com.alura.codechella.infra.persistence.event;

import br.com.alura.codechella.infra.persistence.address.AddressModel;
import br.com.alura.codechella.infra.persistence.ticket.TypeTicketModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventos")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoryEventEnum categoryEventEnum;

    @Column(name = "descricao")
    private String description;

    @Embedded
    private AddressModel address;

    @Column(name = "data")
    private LocalDateTime date;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TypeTicketModel> typeTicketModels = new ArrayList<>();

    public EventModel() {}

    public EventModel(CategoryEventEnum categoryEventEnum, String description, AddressModel address, LocalDateTime date,
                      List<TypeTicketModel> typeTicket) {
        this.setCategory(categoryEventEnum);
        this.setDescription(description);
        this.setAddress(address);
        this.setDate(date);

//        List<TypeTicketModel> tipoIngresso = dados.tipoIngressos().stream()
//                .map(i -> new TypeTicketModel(i.format(), i.definicao(), i.valor(), i.totalDisponivel()))
//                .collect(Collectors.toList());

        this.setTypeTicketModels(typeTicket);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEventEnum getCategory() {
        return categoryEventEnum;
    }

    public void setCategory(CategoryEventEnum categoryEventEnum) {
        this.categoryEventEnum = categoryEventEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<TypeTicketModel> getTypeTicketModels() {
        return typeTicketModels;
    }

    public void setTypeTicketModels(List<TypeTicketModel> typeTicketModels) {
        typeTicketModels.forEach(i -> i.setEvent(this));
        this.typeTicketModels = typeTicketModels;
    }
}