package com.grupo.programaservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "programa_disciplina")
public class ProgramaDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String semestre;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(columnDefinition = "TEXT")
    private String ementa;

    @Column(columnDefinition = "TEXT")
    private String competencia;

    @Column(name = "conteudo_programado", columnDefinition = "TEXT")
    private String conteudoProgramado;

    @Column(name = "processo_avaliacao", columnDefinition = "TEXT")
    private String processoAvaliacao;

    private String sigla;

    private Boolean status;

    @Column(name = "disciplina_id")
    private Long disciplinaId;

    @Column(name = "professor_id")
    private Long professorId;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public ProgramaDisciplina() {
    }

    @PrePersist
    public void antesDeSalvar() {
        this.dataCadastro = LocalDateTime.now();
        this.criadoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();

        if (this.status == null) {
            this.status = true;
        }
    }

    @PreUpdate
    public void antesDeAtualizar() {
        this.atualizadoEm = LocalDateTime.now();
    }

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getConteudoProgramado() {
        return conteudoProgramado;
    }

    public void setConteudoProgramado(String conteudoProgramado) {
        this.conteudoProgramado = conteudoProgramado;
    }

    public String getProcessoAvaliacao() {
        return processoAvaliacao;
    }

    public void setProcessoAvaliacao(String processoAvaliacao) {
        this.processoAvaliacao = processoAvaliacao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }
}