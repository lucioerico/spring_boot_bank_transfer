package itau.canais.api.modules.produto.services;

import itau.canais.api.modules.produto.dto.DadosTransferir;
import itau.canais.api.modules.produto.dto.Operacao;
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
        Conta contaOrigem = contaRepository.buscarContaByAgenciaConta(String.valueOf(origem.agencia()), origem.nconta());
        Conta contaDestino = contaRepository.buscarContaByAgenciaConta(String.valueOf(destino.agencia()), destino.nconta());
        Operacao operacao = origem.operacao();
        BigDecimal valorTransferencia = origem.valorTransferencia();

        verificarTipoTransferencia(operacao, valorTransferencia, contaOrigem, contaDestino, origem, destino);
    }

    private void executaTransferencia(DadosTransferir origem, DadosTransferir destino, Conta contaOrigem, Conta contaDestino, BigDecimal valorTransferencia) {
        if (contaOrigem.getSaldo().compareTo(origem.valorTransferencia()) < 0) {
            throw new RuntimeException("Conta de origem não tem saldo suficiente.");
        }
        BigDecimal novoSaldoOrigem = (contaOrigem.getSaldo()).subtract(valorTransferencia);
        contaOrigem.setSaldo(novoSaldoOrigem);
        contaRepository.save(contaOrigem);
        BigDecimal novoSaldoDestino = contaDestino.getSaldo().add(valorTransferencia);
        contaDestino.setSaldo(novoSaldoDestino);
        contaDestino.transferir(destino, novoSaldoDestino);
        contaRepository.save(contaDestino);
    }

    private void verificarTipoTransferencia(Operacao operacao, BigDecimal valorTransferencia, Conta contaOrigem, Conta contaDestino, DadosTransferir origem, DadosTransferir destino) {
        if (operacao == Operacao.PIX) {
            if (valorTransferencia.compareTo(new BigDecimal("5000")) <= 0) {
                executaTransferencia(origem, destino, contaOrigem, contaDestino, valorTransferencia);
            } else {
                throw new RuntimeException("Valor máximo para transferência via PIX é de R$ 5.000");
            }
        } else if (operacao == Operacao.TED) {
            if (valorTransferencia.compareTo(new BigDecimal("5000")) > 0 && valorTransferencia.compareTo(new BigDecimal("10000")) <= 0) {
                executaTransferencia(origem, destino, contaOrigem, contaDestino, valorTransferencia);
            } else {
                throw new RuntimeException("Valor para transferência via TED deve ser entre R$ 5.001 e R$ 10.000");
            }
        } else if (operacao == Operacao.DOC) {
            if (valorTransferencia.compareTo(new BigDecimal("10000")) >= 0) {
                executaTransferencia(origem, destino, contaOrigem, contaDestino, valorTransferencia);
            } else {
                throw new RuntimeException("Valor mínimo para transferência via DOC é de R$ 10.000");
            }
        } else {
            throw new RuntimeException("Operação inválida");
        }
    }
}




