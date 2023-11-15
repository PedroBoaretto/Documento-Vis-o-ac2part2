package com.example.ac2part2.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendaDTO {
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer horarioInicio;
    private Integer horarioFim;
    private String estado;
    private String cidade;
    private String cep;
    private Long cursoId;
    private Long professorId;
}
