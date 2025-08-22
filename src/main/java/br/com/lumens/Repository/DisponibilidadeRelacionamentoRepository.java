package br.com.lumens.Repository;

import br.com.lumens.Domain.DisponibilidadeRelacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadeRelacionamentoRepository extends JpaRepository<DisponibilidadeRelacionamento, Long> {
}
