package br.com.lumens.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Necessitado {
    private Long id_necessitado;
    private String nome;
    private Endereco endereco;
    private String numero_tel;
    private String necessidade;
}
