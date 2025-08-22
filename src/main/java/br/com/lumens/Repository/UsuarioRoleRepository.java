package br.com.lumens.Repository;

import br.com.lumens.Domain.UsuarioRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRoleRepository extends JpaRepository<UsuarioRole, Long> {
}
