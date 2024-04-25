package br.com.alura.codechella.infra.controllers.event;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventController {

//    @Autowired
//    private EventoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEvento dadosCadastro, UriComponentsBuilder uriBuilder) {
        DadosEvento dadosEvento = service.cadastrarEvento(dadosCadastro);
        var uri = uriBuilder.path("/events/{id}").buildAndExpand(dadosEvento.id()).toUri();
        return ResponseEntity.created(uri).body(dadosEvento);
    }

    @GetMapping
    public ResponseEntity<List<DadosEvento>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

}
