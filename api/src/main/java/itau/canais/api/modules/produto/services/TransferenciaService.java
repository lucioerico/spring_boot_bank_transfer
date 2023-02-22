package itau.canais.api.modules.produto.services;

import itau.canais.api.modules.produto.dto.DadosDepositar;
import itau.canais.api.modules.produto.dto.DadosTransferir;
import itau.canais.api.modules.produto.entities.Conta;
import itau.canais.api.modules.produto.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferenciaService {

    @Autowired
    ContaRepository contaRepository;


    @Transactional
    public void transferir(DadosTransferir origem, DadosTransferir destino) {
        System.out.println("ORIGEM: " + origem);
        System.out.println("DESTINO: " + destino);

        //buscaConta
        Conta contaOrigem = contaRepository.buscarContaByAgenciaConta(String.valueOf(origem.agencia()), origem.nconta());
        Conta contaDestino = contaRepository.buscarContaByAgenciaConta(String.valueOf(destino.agencia()), destino.nconta());

        // TODO verifica se a conta de origem tem saldo suficiente para a transferência // futura implementação pix, doc e ted
        if (contaOrigem.getSaldo().compareTo(origem.valorTransferencia()) < 0) {
            throw new RuntimeException("Conta de origem não tem saldo suficiente.");
        }
        BigDecimal valorTransferencia = origem.valorTransferencia();

        BigDecimal novoSaldoOrigem = (contaOrigem.getSaldo()).subtract(valorTransferencia);
        System.out.println("Valor transferencia: " + valorTransferencia);
        contaOrigem.setSaldo(novoSaldoOrigem);
        contaRepository.save(contaOrigem);

        BigDecimal novoSaldoDestino = contaDestino.getSaldo().add(valorTransferencia);
        contaDestino.setSaldo(novoSaldoDestino);
        contaDestino.transferir(destino, novoSaldoDestino);
        contaRepository.save(contaDestino);
    }

}





