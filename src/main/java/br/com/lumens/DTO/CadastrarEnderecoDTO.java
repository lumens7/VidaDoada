package br.com.lumens.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarEnderecoDTO {
    private Long id_user;
    private String rua;
    private String bairro;
    private Integer numero;
    private String cep;
    private String latitude;
    private String longitude;

    @Override
    public String toString() {
        return "CadastrarEnderecoDTO{" +
                "id_user=" + id_user +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero=" + numero +
                ", cep='" + cep + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
