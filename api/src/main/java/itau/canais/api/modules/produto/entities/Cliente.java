package itau.canais.api.modules.produto.entities;

import itau.canais.api.modules.produto.dto.DadosAtualizacaoCliente;
import itau.canais.api.modules.produto.dto.DadosCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

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

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
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

    public void atualizarInformacoes(DadosAtualizacaoCliente dados, EntityManager entityManager) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.senha() != null){
            this.senha = dados.senha();
        }

        // forçando o carregamento da coleção "contas" dentro da sessão ativa do Hibernate
        Hibernate.initialize(contas);
    }
}
