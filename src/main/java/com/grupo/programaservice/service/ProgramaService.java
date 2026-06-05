package com.grupo.programaservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.programaservice.entity.ProgramaDisciplina;
import com.grupo.programaservice.repository.ProgramaRepository;

@Service
public class ProgramaService {

    @Autowired
    private ProgramaRepository repository;

    // Listar todos
    public List<ProgramaDisciplina> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public ProgramaDisciplina buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));
    }

    // Buscar por disciplina
    public List<ProgramaDisciplina> buscarPorDisciplina(Long disciplinaId) {
        return repository.findByDisciplinaId(disciplinaId);
    }

    // Salvar programa
    public ProgramaDisciplina salvar(ProgramaDisciplina programa) {

        // RN007:
        // Só pode existir um programa ativo por disciplina

        if (Boolean.TRUE.equals(programa.getStatus())) {

            repository.findByDisciplinaIdAndStatusTrue(
                    programa.getDisciplinaId())
                    .ifPresent(p -> {
                        throw new RuntimeException(
                                "Já existe um programa ativo para esta disciplina.");
                    });
        }

        return repository.save(programa);
    }

    // Inativar programa
    public ProgramaDisciplina inativar(Long id) {

        ProgramaDisciplina programa = buscarPorId(id);

        programa.setStatus(false);

        return repository.save(programa);
    }
}