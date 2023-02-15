package itau.canais.api.entities;

import ch.qos.logback.classic.Logger;
import itau.canais.api.dto.DadosAtualizacaoCliente;
import itau.canais.api.dto.DadosCliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="clientes")
@Entity(name="Cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    private String cpf;
    private String nome;
    private String senha;

    @OneToMany(mappedBy = "cliente")
    private List<Conta> contas;

    public Cliente(DadosCliente dadosCliente) {
        this.cpf = dadosCliente.cpf();
        this.nome = dadosCliente.nome();
        this.senha = dadosCliente.senha();

    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.senha() != null){
            this.senha = dados.senha();
        }
    }
}
