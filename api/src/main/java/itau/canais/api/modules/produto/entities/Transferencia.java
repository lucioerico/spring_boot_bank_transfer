package itau.canais.api.modules.produto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "transferencias")
@Entity(name = "Transferencia")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transferencia {

    @Id
    private long id;
    private String agencia;
    private String nconta;
    private BigDecimal saldo;
    private String cpf;
    private BigDecimal valorTransferencia;

}
