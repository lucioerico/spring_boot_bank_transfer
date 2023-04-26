package itau.canais.api;

import itau.canais.api.modules.produto.dto.DadosCliente;
import itau.canais.api.modules.produto.entities.Cliente;
import itau.canais.api.modules.produto.repositories.ClienteRepository;
import itau.canais.api.modules.produto.repositories.UsuarioRepository;
import itau.canais.api.modules.produto.services.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class ClienteServiceTest {

    @InjectMocks // easymock testsubject
    ClienteService clienteService = new ClienteService();

    @Mock
    ClienteRepository clienteRepository;

    @Mock
    UsuarioRepository usuarioRepository;

    @Test
    public void cadastrarClienteTeste() {
        MockitoAnnotations.openMocks(this);
        ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
        DadosCliente teste = new DadosCliente("Teste","Senh@023","00253260078");
        clienteService.cadastrarCliente(teste);
        verify(clienteRepository, times(2)).save(captor.capture());
        Assertions.assertEquals(captor.getValue().getCpf(), teste.cpf());
    }
}
