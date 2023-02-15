package itau.canais.api.controller;

import itau.canais.api.dto.DadosAtualizacaoCliente;
import itau.canais.api.dto.DadosDepositar;
import itau.canais.api.dto.DadosConta;
import itau.canais.api.dto.DadosListagemContas;
import itau.canais.api.entities.Conta;
import itau.canais.api.repositories.ContaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("contas")
public class ContasController {

    @Autowired
    private ContaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarConta(@RequestBody @Valid DadosConta dadosConta){
        repository.save(new Conta(dadosConta));
    }

    @GetMapping
    public List<DadosListagemContas> listar(){
        return repository.findAll().stream().map(DadosListagemContas::new).toList();
    }

    @PutMapping
    @Transactional
    public void depositar(@RequestBody @Valid DadosDepositar dados){
        var conta = repository.buscarContaByAgenciaConta(String.valueOf(dados.agencia()), dados.nconta());
        conta.depositar(dados);
    }

}

//    @PutMapping
//    @Transactional
//    public void depositar(@RequestBody @Valid DadosDepositar dados){
//        Conta conta = repository.buscarContaByAgenciaConta(String.valueOf(dados.agencia()), dados.nconta());
//        conta.depositar(dados);
//    }




//
//    private final ContaService contaService;
//    private final ClienteService clienteService;
//
//    public ContasController(ContaService contaService, ClienteService clienteService) {
//        this.contaService = contaService;
//        this.clienteService = clienteService;
//    }
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity<Conta> criarConta(@RequestBody DadosConta dadosConta) {
//        try {
//            Conta conta = contaService.criarConta(dadosConta);
//            return ResponseEntity.ok(conta);
//        } catch (ClienteNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        } catch (SaldoInsuficienteException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }
//}


