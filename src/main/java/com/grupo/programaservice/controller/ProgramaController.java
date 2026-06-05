package com.grupo.programaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.grupo.programaservice.entity.ProgramaDisciplina;
import com.grupo.programaservice.service.ProgramaService;

@RestController
@RequestMapping("/programas")
public class ProgramaController {

    @Autowired
    private ProgramaService service;

    @GetMapping
    public List<ProgramaDisciplina> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProgramaDisciplina buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/disciplina/{disciplinaId}")
    public List<ProgramaDisciplina> buscarPorDisciplina(@PathVariable Long disciplinaId) {
        return service.buscarPorDisciplina(disciplinaId);
    }

    @PostMapping
    public ProgramaDisciplina salvar(@RequestBody ProgramaDisciplina programa) {
        return service.salvar(programa);
    }

    @PatchMapping("/{id}/inativar")
    public ProgramaDisciplina inativar(@PathVariable Long id) {
        return service.inativar(id);
    }
}