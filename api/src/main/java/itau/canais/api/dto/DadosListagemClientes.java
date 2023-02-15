package itau.canais.api.dto;

import itau.canais.api.entities.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record DadosListagemClientes(
        String nome,
        String cpf){

    public DadosListagemClientes(Cliente cliente){
        this(cliente.getNome(), cliente.getCpf());
    }
}
