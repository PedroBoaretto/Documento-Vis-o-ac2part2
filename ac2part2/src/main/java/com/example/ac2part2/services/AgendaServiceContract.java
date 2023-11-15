package com.example.ac2part2.services;

import java.util.List;

import com.example.ac2part2.dtos.AgendaDTO;

public interface AgendaServiceContract {
    List<AgendaDTO> findAll();
    void create(AgendaDTO agenda);
    List<AgendaDTO> findByProfessor(String nomeProfessor);
}