package itau.canais.api.controller;

import itau.canais.api.dto.DadosCliente;
import itau.canais.api.entities.Cliente;
import itau.canais.api.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCliente dadosCliente){
        repository.save(new Cliente(dadosCliente));
    }

}
