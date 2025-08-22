package br.com.lumens.Repository;

import br.com.lumens.DTO.UsuarioCompletoDTO;
import br.com.lumens.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT p FROM Usuario p WHERE p.nome LIKE %:nome_user%")
    List<Usuario> findByNome(@Param("nome_user") String nome_user);


    @Query(value = """
        SELECT 
          u.id_usuario AS idUsuario,
          u.nome,
          u.documento_pessoal AS documentoPessoal,
          u.mail,
          u.numero_tel AS numeroTel,
          u.senha,
          e.rua,
          e.bairro,
          e.cep,
          e.latitude,
          e.longitude,
          d.dia_semana AS diaSemana,
          d.hora_inicio AS horaInicio,
          d.hora_fim AS horaFim
        FROM usuario u
        LEFT JOIN endereco_relacionamento er ON u.id_usuario = er.id_entidade
        LEFT JOIN endereco e ON er.id_endereco = e.id_endereco
        LEFT JOIN disponibilidade_relacionamento dr ON u.id_usuario = dr.id_entidade
        LEFT JOIN disponibilidade d ON dr.id_disponibilidade = d.id_disponibilidade
        WHERE u.id_usuario = :idUser
        """, nativeQuery = true)
    List<Object[]> pesquisaUsuarioCompleto(@Param("idUser")Long idUser);



}
