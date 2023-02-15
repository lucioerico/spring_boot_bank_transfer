package itau.canais.api.repositories;

import itau.canais.api.entities.Cliente;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    public Cliente buscarPorCpf(@Param("cpf") String cpf);
}
