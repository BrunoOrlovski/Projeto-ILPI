package org.example.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String condicoesMedicas;
    private String contatoEmergencia;

    public Paciente() {}

    public Paciente(String nome, String cpf, LocalDate dataNascimento, String condicoesMedicas, String contatoEmergencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.condicoesMedicas = condicoesMedicas;
        this.contatoEmergencia = contatoEmergencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCondicoesMedicas() {
        return condicoesMedicas;
    }

    public void setCondicoesMedicas(String condicoesMedicas) {
        this.condicoesMedicas = condicoesMedicas;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente{")
                .append("id=").append(id)
                .append(", nome='").append(nome).append('\'')
                .append(", cpf='").append(cpf).append('\'')
                .append(", dataNascimento=").append(dataNascimento)
                .append(", condicoesMedicas='").append(condicoesMedicas).append('\'')
                .append(", contatoEmergencia='").append(contatoEmergencia).append('\'')
                .append('}');
        return sb.toString();
    }
}
