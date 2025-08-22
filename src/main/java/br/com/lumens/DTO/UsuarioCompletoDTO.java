package br.com.lumens.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCompletoDTO {

    private Long idUsuario;
    private String nome;
    private String documentoPessoal;
    private String mail;
    private String numeroTel;
    private String senha;
    private String rua;
    private String bairro;
    private String cep;
    private String latitude;
    private String longitude;
    private DayOfWeek diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;


}
