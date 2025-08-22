package br.com.lumens.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarUsuarioDTO {
    private String nome;
    private String documentoPessoal;
    private String mail;
    private String numero_tel;
    private String senha;
    private String disponibilidade;
    private List<Long> rolesIds;
}
