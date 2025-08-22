package br.com.lumens.Repository;

import br.com.lumens.Domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = """
        SELECT e.* FROM Endereco e
        INNER JOIN endereco_relacionamento er ON e.id_endereco = er.id_endereco
        INNER JOIN usuario u ON u.id_usuario = er.id_entidade
        WHERE u.id_usuario = :idUsuario
        """, nativeQuery = true)
    List<Endereco> buscarEnderecosPorUsuario(@Param("idUsuario") Long idUsuario);


    @Query("SELECT p FROM Endereco p WHERE p.latitude = :latitude_end AND p.longitude = :longitude_end")
    Endereco findByLatitudeAndLongitude(
            @Param("latitude_end")String latitude,
            @Param("longitude_end")String longitude
    );
}
