package br.com.lumens.Repository;

import br.com.lumens.Domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

    @Query("SELECT p FROM Doacao p WHERE p.nome LIKE %:nome_doacao%")
    List<Doacao> findByNome(@Param("nome_doacao")String nome_doacao);
}
