package br.com.lumens.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doacao {

    public enum Classe_doacao{
        ALIMENTO, ROUPA, EQUIPAMENTO, MOVEL, OUTRO;
    }
    public enum Condicao_doacao{
        novo, bem_conservado, pouco_conservado, em_condicoes;
    }

    private Long id_doacao;
    private String nome;
    private String descricao;
    private LocalDate data_cadastro;
    private Classe_doacao classe_doacao;
    private Boolean perecivel;
    private LocalDate data_validade;
    private Condicao_doacao condicao_doacao;
    private Date tempo_uso;
    private String image_url;

}
