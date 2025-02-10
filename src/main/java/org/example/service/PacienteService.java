package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.PacienteDao;
import org.example.model.Paciente;

import java.util.List;

public class PacienteService {
    private PacienteDao pacienteDao;

    public PacienteService(EntityManager em) {
        pacienteDao = new PacienteDao(em);
    }

    // Inserir Paciente
    public void inserir(Paciente paciente) {
        pacienteDao.cadastrar(paciente);
    }

    // Alterar dados do Paciente
    public void alterar(Paciente paciente) {
        pacienteDao.atualizar(paciente);
    }

    // Excluir Paciente
    public void excluir(Paciente paciente) {
        pacienteDao.remover(paciente);
    }

    // Buscar Paciente por ID
    public Paciente buscarPacientePorId(Long id) {
        return pacienteDao.buscarPorId(id);
    }

    // Consultar Paciente por CPF
    public Paciente buscarPacientePorCpf(String cpf) {
        return pacienteDao.buscarPorCpf(cpf);
    }

    // Listar todos os Pacientes
    public List<Paciente> buscarTodosOsPacientes() {
        return pacienteDao.buscarTodos();
    }
}
