package itau.canais.api.modules.produto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name="transferencias")
@Entity(name="Transferencia")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    @JoinColumn(name = "conta_origem_agencia")
    public Conta contaOrigem;
    @ManyToOne
    @JoinColumn(name = "conta_destino_agencia")
    public Conta contaDestino;
    public BigDecimal valor;


    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
}
