package itau.canais.api.modules.produto.services;

import itau.canais.api.modules.produto.dto.DadosAtualizacaoCliente;
import itau.canais.api.modules.produto.dto.DadosCliente;
import itau.canais.api.modules.produto.dto.DadosListagemClientes;
import itau.canais.api.modules.produto.entities.Cliente;
import itau.canais.api.modules.produto.entities.Usuario;
import itau.canais.api.modules.produto.repositories.ClienteRepository;
import itau.canais.api.modules.produto.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static java.lang.constant.ConstantDescs.NULL;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ClienteServiceTest {

    public static final String CPF     = "61810806003";
    public static final String NOME = "Cliente Service Test";
    public static final String SENHA   = "Senh@023";
    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private Cliente cliente;

    @Mock
    private Usuario usuario;


    private DadosCliente dadosCliente;


    private DadosAtualizacaoCliente dadosAtualizacaoCliente;


    private List<DadosListagemClientes> dadosListagemClientes;


    private List<Cliente> clienteList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCliente();
    }

    @Test
    void QuandoCadastroClienteETenhoSucesso() {
        Mockito.when(repository.save(any())).thenReturn(cliente);
        Cliente resposta = repository.save(new Cliente(dadosCliente));
        Assertions.assertNotNull(resposta);
        Assertions.assertEquals(Cliente.class, resposta.getClass());
        Assertions.assertEquals(NOME, resposta.getNome());
        Assertions.assertEquals(CPF, resposta.getCpf());
        Assertions.assertEquals(SENHA, resposta.getSenha());
    }


    private void startCliente(){
        cliente = new Cliente(CPF, NOME, SENHA,null);
        dadosCliente = new DadosCliente(CPF, NOME, SENHA);
        clienteList = List.of(new Cliente(CPF, NOME, SENHA,null));
        dadosListagemClientes = List.of(new DadosListagemClientes(CPF, NOME));

    }
}