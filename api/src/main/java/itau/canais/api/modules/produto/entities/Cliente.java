package itau.canais.api.modules.produto.entities;

import itau.canais.api.modules.produto.dto.DadosAtualizacaoCliente;
import itau.canais.api.modules.produto.dto.DadosCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
