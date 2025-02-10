package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes_medicas")
public class AvaliacaoMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  // Relacionamento correto com a entidade Paciente
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne  // Relacionamento correto com a entidade ProfissionalSaude
    @JoinColumn(name = "profissional_id")
    private ProfissionalSaude profissional;

    private LocalDateTime data;
    private String hora;
    private String observacoes;
    private String diagnostico;
    private String medicamentos;

    public AvaliacaoMedica() {
    }

    public AvaliacaoMedica(Paciente paciente, ProfissionalSaude profissional, LocalDateTime data, String hora, String observacoes, String diagnostico, String medicamentos) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.data = data;
        this.hora = hora;
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.medicamentos = medicamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfissionalSaude getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalSaude profissional) {
        this.profissional = profissional;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Override
    public String toString() {
        return "AvaliacaoMedica{" +
                "id=" + id +
                ", paciente=" + (paciente != null ? paciente.getId() : "null") +
                ", profissional=" + (profissional != null ? profissional.getId() : "null") +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", medicamentos='" + medicamentos + '\'' +
                '}';
    }
}
