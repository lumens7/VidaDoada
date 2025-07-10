package br.com.lumens.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doador {

    private Long id_doador;
    private String nome;
    private String cpf;
    private String mail;
    private Endereco endereco;
    private String numero_tel;
    private String senha;
    private LocalDate disponibilidade;
}
