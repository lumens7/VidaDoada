package br.com.lumens.Repository;

import br.com.lumens.Domain.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {


    @Query(value = """
        SELECT d.* FROM disponibilidade d
        INNER JOIN disponibilidade_relacionamento dr
        ON d.id_disponibilidade = dr.id_disponibilidade
        INNER JOIN usuario u 
        ON dr.id_entidade = u.id_usuario
        WHERE u.id_usuario = :idUsuario
    """, nativeQuery = true)
    List<Disponibilidade> buscarDisponibilidadePorUsuario(@Param("idUsuario") Long idUsuario);


    @Query("""
        SELECT p FROM Disponibilidade p
        WHERE p.id_user = :id_usuario
        AND p.diaSemana = :diaSem
        AND p.horaInicio = :horaIni
        AND p.horaFim = :horaF
    """)
    Disponibilidade pesquisarPorTodosCampos(
            @Param("id_usuario") Long id_user,
            @Param("diaSem") DayOfWeek diaSemana,
            @Param("horaIni") LocalTime horaInicio,
            @Param("horaF") LocalTime horaFim
    );

}
