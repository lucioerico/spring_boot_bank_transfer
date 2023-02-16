package itau.canais.api.modules.produto.services;

import itau.canais.api.modules.produto.dto.DadosAtualizacaoCliente;
import itau.canais.api.modules.produto.dto.DadosCliente;
import itau.canais.api.modules.produto.dto.DadosListagemClientes;
import itau.canais.api.modules.produto.entities.Cliente;
import itau.canais.api.modules.produto.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void cadastrarCliente(DadosCliente dadosCliente){
        repository.save(new Cliente(dadosCliente));
    }

    public List<DadosListagemClientes> listarClientes(){
        return repository.findAll().stream().map(DadosListagemClientes::new).toList();
    }

    public void atualizarCliente(DadosAtualizacaoCliente dados){
        var cliente = repository.buscarPorCpf(String.valueOf(dados.cpf()));
        cliente.atualizarInformacoes(dados);
    }
}
