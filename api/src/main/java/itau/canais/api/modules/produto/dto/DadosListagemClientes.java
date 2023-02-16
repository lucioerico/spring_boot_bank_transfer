package itau.canais.api.modules.produto.dto;

import itau.canais.api.modules.produto.entities.Cliente;

public record DadosListagemClientes(
        String nome,
        String cpf){

    public DadosListagemClientes(Cliente cliente){
        this(cliente.getNome(), cliente.getCpf());
    }
}
