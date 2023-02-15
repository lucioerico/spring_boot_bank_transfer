//package itau.canais.api.services;
//
//import itau.canais.api.dto.DadosConta;
//import itau.canais.api.entities.Cliente;
//import itau.canais.api.entities.Conta;
//import itau.canais.api.repositories.ContaRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//@Service
//public class ContaService {
//
//    private final ContaRepository contaRepository;
//    private final ClienteService clienteService;
//
//    public ContaService(ContaRepository contaRepository, ClienteService clienteService) {
//        this.contaRepository = contaRepository;
//        this.clienteService = clienteService;
//    }
//
//    @Transactional
//    public Conta criarConta(String agencia, String nconta, BigDecimal saldo, String cpf) {
//        Optional<Cliente> clienteOptional = clienteService.buscarClientePorCpf(cpf);
//        if (clienteOptional.isPresent()) {
//            Conta conta = new Conta(agencia, nconta, saldo, cpf, clienteOptional.get());
//            return contaRepository.save(conta);
//        } else {
//            throw new RuntimeException("Cliente não encontrado");
//        }
//    }
//
//
//    public Optional<Conta> buscarContaPorId(Long id) {
//        return contaRepository.findById(id);
//    }
//
//    public Conta criarConta(DadosConta dadosConta) {
//    }
//}
