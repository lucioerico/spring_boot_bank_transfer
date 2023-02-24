package itau.canais.api.modules.produto.controller;

import itau.canais.api.modules.produto.dto.DadosTransferir;
import itau.canais.api.modules.produto.dto.TransferenciaRequest;
import itau.canais.api.modules.produto.entities.Conta;
import itau.canais.api.modules.produto.exceptions.TransferenciaException;
import itau.canais.api.modules.produto.repositories.ContaRepository;
import itau.canais.api.modules.produto.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.RoundingMode;

@RestController
@RequestMapping("transferencias")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @Autowired
    ContaRepository contaRepository;

    @PostMapping(value ="/transferir", consumes={"application/xml", "application/json","aplication/x-ww-form-urlencoded"})
    @Transactional
    @CacheEvict (value = "serviceList", allEntries = true)
    public ResponseEntity<String> transferir(@RequestBody TransferenciaRequest request, UriComponentsBuilder uriBuilder) {
        DadosTransferir origem = request.getOrigem();
        DadosTransferir destino = request.getDestino();
        try {
            transferenciaService.transferir(origem, destino);
            //TODO colocar o contaService no lugar
            Conta contaOrigem = contaRepository.buscarContaByAgenciaConta(String.valueOf(origem.agencia()), origem.nconta());
            Conta contaDestino = contaRepository.buscarContaByAgenciaConta(String.valueOf(destino.agencia()), destino.nconta());
            String mensagem = String.format("Sua transferência foi realizada com sucesso!\nSaldo do emissor: R$ %s\nSaldo do receptor: R$ %s", contaOrigem.getSaldo().setScale(2, RoundingMode.HALF_EVEN), contaDestino.getSaldo().setScale(2, RoundingMode.HALF_EVEN));
            return ResponseEntity.ok().body(mensagem);
        } catch (TransferenciaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
