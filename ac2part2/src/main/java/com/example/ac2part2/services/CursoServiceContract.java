package com.example.ac2part2.services;

import java.util.List;

import com.example.ac2part2.dtos.CursoCreateDTO;
import com.example.ac2part2.dtos.CursoDTO;
import com.example.ac2part2.dtos.UpdateListLongDTO;

public interface CursoServiceContract {
    List<CursoDTO> findAll();
    void create(CursoCreateDTO curso);
    void updateProfessores(Long id, UpdateListLongDTO curso);
}
