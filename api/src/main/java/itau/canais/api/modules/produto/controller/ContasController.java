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
import java.util.stream.Collectors;

@RestController
@RequestMapping("contas")
public class ContasController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/criar")
    public ResponseEntity cadastrarConta(@RequestBody @Valid DadosConta dadosConta, UriComponentsBuilder uriBuilder){
        var conta = new Conta(dadosConta);
        contaService.cadastrarConta(dadosConta);
        var uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getCpf()).toUri();
        return ResponseEntity.created(uri).body("Cadastrado com sucesso");
    }

    // TODO implementar quando for feito niveis de acesso
    @PutMapping
    public ResponseEntity depositar(@RequestBody @Valid DadosDepositar dados){
        contaService.depositar(dados);
        return ResponseEntity.ok("Deposito Gerencial efetuado com sucesso");
    }

    @GetMapping("/listar")
    public List<DadosListagemContas> listarContas() {
        return contaService.listarContas()
                .stream()
                .map(conta -> new DadosListagemContas(conta.getAgencia(), conta.getNconta(), conta.getCpf(), conta.getSaldo()))
                .collect(Collectors.toList());
    }

}
