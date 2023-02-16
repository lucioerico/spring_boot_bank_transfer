package itau.canais.api.modules.controller;

import itau.canais.api.modules.dto.DadosConta;
import itau.canais.api.modules.dto.DadosDepositar;
import itau.canais.api.modules.dto.DadosListagemContas;
import itau.canais.api.modules.services.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contas")
public class ContasController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public void cadastrarConta(@RequestBody @Valid DadosConta dadosConta){
        contaService.cadastrarConta(dadosConta);
    }

    @GetMapping
    public List<DadosListagemContas> listar(){
        return contaService.listar();
    }

    @PutMapping
    public void depositar(@RequestBody @Valid DadosDepositar dados){
        contaService.depositar(dados);
    }
}
