package itau.canais.api.modules.produto.controller;

import itau.canais.api.modules.produto.dto.DadosConta;
import itau.canais.api.modules.produto.dto.DadosDepositar;
import itau.canais.api.modules.produto.dto.DadosListagemContas;
import itau.canais.api.modules.produto.entities.Conta;
import itau.canais.api.modules.produto.services.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("contas")
public class ContasController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity cadastrarConta(@RequestBody @Valid DadosConta dadosConta, UriComponentsBuilder uriBuilder){
        var conta = new Conta(dadosConta);
        contaService.cadastrarConta(dadosConta);
        var uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getCpf()).toUri();
        return ResponseEntity.created(uri).body("Cadastrado com sucesso");
    }

    @GetMapping
    public List<DadosListagemContas> listar(){
        return contaService.listar();
    }

    @PutMapping
    public ResponseEntity depositar(@RequestBody @Valid DadosDepositar dados){
        contaService.depositar(dados);
        return ResponseEntity.ok("Deposito Gerencial efetuado com sucesso");
    }

}
