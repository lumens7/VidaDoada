package br.com.lumens.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String rua;
    private String bairro;
    private Integer numero;
    private String cep;
    private String latitude;
    private String longitude;
}
