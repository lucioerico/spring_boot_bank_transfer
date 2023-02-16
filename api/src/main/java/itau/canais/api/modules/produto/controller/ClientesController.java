package itau.canais.api.modules.produto.controller;

import itau.canais.api.modules.produto.dto.DadosAtualizacaoCliente;
import itau.canais.api.modules.produto.dto.DadosCliente;
import itau.canais.api.modules.produto.dto.DadosListagemClientes;
import itau.canais.api.modules.produto.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCliente dadosCliente){
        clienteService.cadastrarCliente(dadosCliente);
    }

    @GetMapping
    public List<DadosListagemClientes> listar(){
        return clienteService.listarClientes();
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dados){
        clienteService.atualizarCliente(dados);
    }
}
