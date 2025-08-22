package br.com.lumens.Repository;

import br.com.lumens.Domain.EnderecoRelacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRelacionamentoRepository extends JpaRepository<EnderecoRelacionamento, Long> {
}
