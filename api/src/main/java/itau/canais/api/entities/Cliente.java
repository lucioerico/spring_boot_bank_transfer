package itau.canais.api.entities;

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
}
