package itau.canais.api.modules.produto.controller;

import itau.canais.api.modules.produto.dto.DadosTransferir;
import itau.canais.api.modules.produto.dto.TransferenciaRequest;
import itau.canais.api.modules.produto.entities.Conta;
import itau.canais.api.modules.produto.entities.Transferencia;
import itau.canais.api.modules.produto.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("transferencias")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;


    @PutMapping
    @Transactional
    @CacheEvict (value = "serviceList", allEntries = true)
    public void transferir(@RequestBody TransferenciaRequest request, UriComponentsBuilder uriBuilder){
        DadosTransferir origem = request.getOrigem();
        DadosTransferir destino = request.getDestino();
        transferenciaService.transferir(origem, destino);

    }
}
