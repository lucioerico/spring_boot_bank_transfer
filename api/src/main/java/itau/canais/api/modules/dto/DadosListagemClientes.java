package itau.canais.api.modules.dto;

import itau.canais.api.modules.entities.Cliente;

public record DadosListagemClientes(
        String nome,
        String cpf){

    public DadosListagemClientes(Cliente cliente){
        this(cliente.getNome(), cliente.getCpf());
    }
}
