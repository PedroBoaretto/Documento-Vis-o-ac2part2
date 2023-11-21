package com.example.ac2part2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2part2.dtos.CursoCreateDTO;
import com.example.ac2part2.dtos.CursoDTO;
import com.example.ac2part2.dtos.UpdateListLongDTO;
import com.example.ac2part2.exceptions.RegraNegocioException;
import com.example.ac2part2.models.Curso;
import com.example.ac2part2.models.Professor;
import com.example.ac2part2.repositories.CursoRepository;
import com.example.ac2part2.repositories.ProfessorRepository;

@Service
public class CursoService implements CursoServiceContract {

    private CursoRepository cursoRepository;

    private ProfessorRepository professorRepository;

    public CursoService(CursoRepository cursoRepository, ProfessorRepository professorRepository) {
        this.cursoRepository = cursoRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public void create(CursoCreateDTO curso) {

        Curso cursoSaved = Curso.builder()
                .id(curso.getId())
                .descricao(curso.getDescricao())
                .cargaHoraria(curso.getCargaHoraria())
                .objetivo(curso.getObjetivo())
                .ementa(curso.getEmenta())
                .build();

        cursoRepository.save(cursoSaved);
    }

    @Override
    public void updateProfessores(Long id, UpdateListLongDTO professorList) {

        Curso cursoEncontrado = cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Não foi possível encontrar o ID do curso fornecido."));

        List<Professor> professorListFound = professorRepository.findAllById(professorList.getLongList());

        if (professorListFound.size() != professorList.getLongList().size()) {
            throw new RegraNegocioException("Um ou mais professores não foram encontrados dentro da lista.");
        }

        cursoEncontrado.setProfessorList(professorListFound);
        cursoRepository.save(cursoEncontrado);
    }

    @Override
    public List<CursoDTO> findAll() {
        return cursoRepository.findAll().stream().map(
                (Curso curso) -> {
                    List<Long> professorIds = curso.getProfessorList().stream()
                            .map(professor -> professor.getId())
                            .collect(Collectors.toList());

                    return CursoDTO.builder()
                            .id(curso.getId())
                            .descricao(curso.getDescricao())
                            .cargaHoraria(curso.getCargaHoraria())
                            .objetivo(curso.getObjetivo())
                            .ementa(curso.getEmenta())
                            .professorList(professorIds)
                            .build();
                })
                .collect(Collectors.toList());
    }

}
