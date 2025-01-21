package itau.canais.api.service;

import itau.canais.api.modules.produto.dto.DadosAtualizacaoCliente;
import itau.canais.api.modules.produto.dto.DadosCliente;
import itau.canais.api.modules.produto.dto.DadosListagemClientes;
import itau.canais.api.modules.produto.entities.Cliente;
import itau.canais.api.modules.produto.entities.Usuario;
import itau.canais.api.modules.produto.repositories.ClienteRepository;
import itau.canais.api.modules.produto.repositories.UsuarioRepository;
import itau.canais.api.modules.produto.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private ClienteService clienteService;

    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void testCadastrarCliente() {
        // Dados de entrada
        DadosCliente dadosCliente = new DadosCliente(
                "João Silva",
                "123.456.789-00",
                "joao.silva@example.com",
                "senha123"
        );

        // Chama o método a ser testado
        clienteService.cadastrarCliente(dadosCliente);

        // Verifica se clienteRepository.save foi chamado duas vezes
        verify(clienteRepository, times(2)).save(any(Cliente.class));

        // Verifica se usuarioRepository.save foi chamado uma vez
        verify(usuarioRepository, times(1)).save(any(Usuario.class));

        // Captura o Cliente salvo para verificar a senha
        ArgumentCaptor<Cliente> clienteCaptor = ArgumentCaptor.forClass(Cliente.class);
        verify(clienteRepository, atLeastOnce()).save(clienteCaptor.capture());
        Cliente clienteSalvo = clienteCaptor.getValue();

        // Verifica se a senha foi codificada
        assertTrue(passwordEncoder.matches(dadosCliente.senha(), clienteSalvo.getSenha()));
    }

    @Test
    public void testListarClientes() {
        // Dados de exemplo
        Cliente cliente1 = new Cliente(/* inicialize com dados apropriados */);
        cliente1.setNome("Cliente 1");
        Cliente cliente2 = new Cliente(/* inicialize com dados apropriados */);
        cliente2.setNome("Cliente 2");

        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        // Mock do repository.findAll()
        when(clienteRepository.findAll()).thenReturn(clientes);

        // Chama o método a ser testado
        List<DadosListagemClientes> resultado = clienteService.listarClientes();

        // Verificações
        assertNotNull(resultado);
        assertEquals(2, resultado.size());

        // Verifica se repository.findAll() foi chamado uma vez
        verify(clienteRepository, times(1)).findAll();

        // Verifica os nomes dos clientes
        assertEquals("Cliente 1", resultado.get(0).nome());
        assertEquals("Cliente 2", resultado.get(1).nome());
    }

    @Test
    public void testAtualizarCliente() {
        // Dados de entrada
        String cpf = "123.456.789-00";
        DadosAtualizacaoCliente dadosAtualizacao = new DadosAtualizacaoCliente(
                cpf,
                "João Atualizado",
                "joao.atualizado@example.com",
                "novaSenha123"
        );

        // Cliente existente no repositório
        Cliente clienteExistente = mock(Cliente.class);
        clienteExistente.setCpf(cpf);
        // Inicialize outros campos conforme necessário

        // Mock do repository.buscarPorCpf()
        when(clienteRepository.buscarPorCpf(cpf)).thenReturn(clienteExistente);

        // Chama o método a ser testado
        clienteService.atualizarCliente(dadosAtualizacao);

        // Verificações
        // Verifica se buscarPorCpf foi chamado com o CPF correto
        verify(clienteRepository, times(1)).buscarPorCpf(cpf);

        // Verifica se atualizarInformacoes foi chamado no cliente
        verify(clienteExistente, times(1)).atualizarInformacoes(dadosAtualizacao);
    }
}


