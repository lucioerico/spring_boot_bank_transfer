package itau.canais.api.modules.produto.controller;

import itau.canais.api.modules.produto.dto.DadosAtualizacaoCliente;
import itau.canais.api.modules.produto.dto.DadosCliente;
import itau.canais.api.modules.produto.dto.DadosListagemClientes;
import itau.canais.api.modules.produto.entities.Cliente;
import itau.canais.api.modules.produto.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid DadosCliente dadosCliente,  UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(dadosCliente);
        clienteService.cadastrarCliente(dadosCliente);
        var uri =uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getCpf()).toUri();
        return ResponseEntity.created(uri).body("Cadastrado com sucesso");
    }

    @GetMapping
    public List<DadosListagemClientes> listar(){
        return clienteService.listarClientes();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dados){
        clienteService.atualizarCliente(dados);
        return ResponseEntity.ok("Atualizado com sucesso");

    }

    @GetMapping("/listar")
    public List<DadosListagemClientes> listarClientes() {
        return clienteService.listarClientes();
    }
}
