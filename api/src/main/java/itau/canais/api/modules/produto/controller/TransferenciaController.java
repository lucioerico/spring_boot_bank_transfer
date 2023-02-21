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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("transferencias")
public class TransferenciaController {


    @PostMapping
    @Transactional
    @CacheEvict (value = "serviceList", allEntries = true)
    public void transferir(@RequestBody TransferenciaRequest request, UriComponentsBuilder uriBuilder){
        DadosTransferir origem = request.getOrigem();
        DadosTransferir destino = request.getDestino();
        System.out.println("ORIGEM: " + origem);
        System.out.println("DESTINO: " + destino);

    }
}
