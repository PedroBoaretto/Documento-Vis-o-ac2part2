package com.example.ac2part2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ac2part2.models.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long>{
    
}
