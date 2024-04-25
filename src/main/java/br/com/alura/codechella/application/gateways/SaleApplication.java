package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entity.sale.Sale;

import java.util.List;

public interface SaleApplication {

    Sale save(Sale sale);

    List<Sale> listAll();

}
