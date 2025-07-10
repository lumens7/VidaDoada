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
public class Usuario {
    /*
    há três tipos de usuário,
    o usuário que ira fazer as doações,
    a entidade que ira se responsabilizar pelas doações
    e os colaboradores desta entidade.
     */

    private Long id_usuario;
    private String nome;
    private String documentoPessoal; //pode ser cpf, cnpj (no caso de empresa)
    private String mail;
    private Endereco endereco;
    private String numero_tel;
    private String senha;
    private Roles roles[];
    private LocalDate disponibilidade;
}
