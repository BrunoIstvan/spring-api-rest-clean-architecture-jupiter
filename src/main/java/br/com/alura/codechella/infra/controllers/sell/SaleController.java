package br.com.alura.codechella.infra.controllers.sell;

import br.com.alura.codechella.application.usecases.sale.CreateSale;
import br.com.alura.codechella.domain.entity.sale.SaleFactory;
import br.com.alura.codechella.infra.controllers.dtos.RegistrationSaleDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final CreateSale createSale;


    public SaleController(CreateSale createSale) {
        this.createSale = createSale;
    }

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody @Valid RegistrationSaleDTO saleDTO, UriComponentsBuilder uriBuilder) {
        var factory = new SaleFactory();
        var entity = factory.createIdUserTickets(null, saleDTO.userId(), saleDTO.tickets());
        DadosVenda venda = service.cadastrarVenda(saleDTO);
        var uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.id()).toUri();

        return ResponseEntity.created(uri).body(venda);
    }
}
