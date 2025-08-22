package br.com.lumens.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class CadastrarDisponibilidadeDTO {
    private Long id_user;
    private DayOfWeek diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;

}
