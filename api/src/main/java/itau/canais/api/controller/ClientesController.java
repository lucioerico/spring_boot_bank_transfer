package itau.canais.api.controller;

import itau.canais.api.dto.DadosAtualizacaoCliente;
import itau.canais.api.dto.DadosCliente;
import itau.canais.api.dto.DadosListagemClientes;
import itau.canais.api.entities.Cliente;
import itau.canais.api.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

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

    @GetMapping
    public List<DadosListagemClientes> listar(){
        return repository.findAll().stream().map(DadosListagemClientes::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.buscarPorCpf(String.valueOf(dados.cpf()));
        cliente.atualizarInformacoes(dados);
    }
}
