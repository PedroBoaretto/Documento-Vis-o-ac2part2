package com.example.ac2part2.services;

import java.util.List;
import com.example.ac2part2.dtos.ProfessorDTO;
import com.example.ac2part2.dtos.UpdateListLongDTO;

public interface ProfessorServiceContract {
    List<ProfessorDTO> findAll();
    void create(ProfessorDTO professor);
    void update(Long id, UpdateListLongDTO cursoList);
    Boolean login(String nome, String cpf);
}
