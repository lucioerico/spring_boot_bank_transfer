//package itau.canais.api.services;
//
//import itau.canais.api.entities.Cliente;
//import itau.canais.api.repositories.ClienteRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ClienteService {
//
//    private final ClienteRepository repository;
//
//    @Autowired
//    public ClienteService(ClienteRepository repository) {
//        this.repository = repository;
//    }
//
//    public Cliente salvar(Cliente cliente) {
//        return repository.save(cliente);
//    }
//
//    public List<Cliente> listarClientes() {
//        return repository.findAll();
//    }
//
//    public Optional<Cliente> buscarPorId(Long id) {
//        return repository.findById(id);
//    }
//
//    public Optional<Cliente> buscarPorCpf(String cpf) {
//        return repository.findByCpf(cpf);
//    }
//
//    public Optional<Cliente> buscarClientePorCpf(String cpf) {
//        return repository.findByCpf(cpf);
//    }
//}