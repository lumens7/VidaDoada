package br.com.lumens.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "disponibilidade_relacionamento")
public class DisponibilidadeRelacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disponibilidade_relacionamento;
    private Long id_entidade;
    private Long id_disponibilidade;

}
