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
@Table(name = "necessitado")
public class Necessitado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_necessitado;
    private String nome;
    private String numero_tel;
    private String necessidade;
}
