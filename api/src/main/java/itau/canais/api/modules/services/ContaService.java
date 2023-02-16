package itau.canais.api.modules.services;

import itau.canais.api.modules.dto.DadosConta;
import itau.canais.api.modules.dto.DadosDepositar;
import itau.canais.api.modules.dto.DadosListagemContas;
import itau.canais.api.modules.entities.Conta;
import itau.canais.api.modules.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}

