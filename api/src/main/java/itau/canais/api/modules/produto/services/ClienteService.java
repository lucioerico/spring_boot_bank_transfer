package itau.canais.api.modules.produto.services;

import itau.canais.api.modules.produto.dto.DadosAtualizacaoCliente;
import itau.canais.api.modules.produto.dto.DadosCliente;
import itau.canais.api.modules.produto.dto.DadosListagemClientes;
import itau.canais.api.modules.produto.entities.Cliente;
import itau.canais.api.modules.produto.entities.Usuario;
import itau.canais.api.modules.produto.repositories.ClienteRepository;
import itau.canais.api.modules.produto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrarCliente(DadosCliente dadosCliente){
        Cliente cliente = new Cliente(dadosCliente);
        cliente.setSenha(new BCryptPasswordEncoder().encode(dadosCliente.senha()));
        repository.save(new Cliente(dadosCliente));
        // Salva o cliente no banco de dados
        repository.save(cliente);
        // Cria o objeto Usuario a partir dos dados do cliente
        Usuario usuario = new Usuario();
        usuario.setLogin(dadosCliente.cpf()); // Usa o CPF como login
        usuario.setSenha(new BCryptPasswordEncoder().encode(dadosCliente.senha())); // Usa a senha do cliente
        // Salva o usuário no banco de dados
        usuarioRepository.save(usuario);
    }

    public List<DadosListagemClientes> listarClientes(){
        return repository.findAll().stream().map(DadosListagemClientes::new).toList();
    }

    public void atualizarCliente(DadosAtualizacaoCliente dados){
        var cliente = repository.buscarPorCpf(String.valueOf(dados.cpf()));
        cliente.atualizarInformacoes(dados);
    }
}
