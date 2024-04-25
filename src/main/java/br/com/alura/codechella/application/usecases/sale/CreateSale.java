package br.com.alura.codechella.application.usecases.sale;

import br.com.alura.codechella.application.gateways.SaleApplication;
import br.com.alura.codechella.domain.entity.sale.Sale;

public class CreateSale {

    private final SaleApplication application;


    public CreateSale(SaleApplication application) {
        this.application = application;
    }

    public Sale save(Sale sale) {
        return application.save(sale);
    }

}
