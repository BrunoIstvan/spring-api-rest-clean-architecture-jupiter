package br.com.alura.codechella.infra.persistence.ticket;


import br.com.alura.codechella.infra.persistence.sale.SaleModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ingressos")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private int code;

    @ManyToOne
    private TypeTicketModel typeTicket;

    @ManyToOne
    @JsonIgnore
    private SaleModel sell;

    public TicketModel() {}

    public TicketModel(int code, TypeTicketModel typeTicket) {
        this.setCode(code);
        this.setTypeTicket(typeTicket);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TypeTicketModel getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(TypeTicketModel typeTicket) {
        this.typeTicket = typeTicket;
    }

    public SaleModel getSell() {
        return sell;
    }

    public void setSell(SaleModel sell) {
        this.sell = sell;
    }
}