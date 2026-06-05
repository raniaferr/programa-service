package com.grupo.programaservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo.programaservice.entity.ProgramaDisciplina;

public interface ProgramaRepository extends JpaRepository<ProgramaDisciplina, Long> {

    List<ProgramaDisciplina> findByDisciplinaId(Long disciplinaId);

    Optional<ProgramaDisciplina> findByDisciplinaIdAndStatusTrue(Long disciplinaId);

}