package br.com.lumens.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    /*
    há três tipos de usuário,
    o usuário que ira fazer as doações,
    a entidade que ira se responsabilizar pelas doações
    e os colaboradores desta entidade.
     */
    public enum Status{
        ATIVO, INATIVO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nome;
    private String documentoPessoal; //pode ser cpf, cnpj (no caso de empresa)
    private String mail;

    //endereço
    private String numero_tel;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Roles> roles = new ArrayList<>();
    //private Status status_user;
}
