package itau.canais.api.modules.produto.services;

import itau.canais.api.modules.produto.dto.DadosConta;
import itau.canais.api.modules.produto.dto.DadosDepositar;
import itau.canais.api.modules.produto.dto.DadosListagemContas;
import itau.canais.api.modules.produto.entities.Conta;
import itau.canais.api.modules.produto.repositories.ContaRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    @Transactional
    public void cadastrarConta(DadosConta dadosConta){
        repository.save(new Conta(dadosConta));
    }

    public List<DadosListagemContas> listar(){
        return repository.findAll().stream().map(DadosListagemContas::new).toList();
    }

    @Transactional
    public void depositar(DadosDepositar dados){
        var conta = repository.buscarContaByAgenciaConta(String.valueOf(dados.agencia()), dados.nconta());
        conta.depositar(dados);
    }

    @Transactional
    public ResponseEntity transferir(@RequestBody DadosDepositar dados){
        var conta = repository.buscarContaByAgenciaConta(String.valueOf(dados.agencia()), dados.nconta());
        conta.depositar(dados);
        return ResponseEntity.ok("Transferencia efetuada com sucesso");
    }

    @Transactional
    public List<Conta> listarContas() {
        return repository.findAll();
    }

}

