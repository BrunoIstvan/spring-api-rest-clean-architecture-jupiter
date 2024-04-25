package br.com.alura.codechella.domain.entity.ticket;

import br.com.alura.codechella.infra.persistence.event.SectorEventEnum;

public class Ticket {

    private Long id;

    private int code;

    private SectorEventEnum sector;

    private Long saleId;

    public Ticket(Long id, int code, SectorEventEnum sector, Long saleId) {
        this.setId(id);
        this.setCode(code);
        this.setSector(sector);
        this.setSaleId(saleId);
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

    public SectorEventEnum getSector() {
        return sector;
    }

    public void setSector(SectorEventEnum sector) {
        this.sector = sector;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
