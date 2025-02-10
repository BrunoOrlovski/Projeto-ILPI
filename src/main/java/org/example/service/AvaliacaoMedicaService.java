package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.AvaliacaoMedicaDao;
import org.example.model.AvaliacaoMedica;

import java.time.LocalDateTime;
import java.util.List;

public class AvaliacaoMedicaService {
    private AvaliacaoMedicaDao avaliacaoMedicaDao;

    public AvaliacaoMedicaService(EntityManager em) {
        avaliacaoMedicaDao = new AvaliacaoMedicaDao(em);
    }

    // Registrar Avaliação Médica
    public void registrar(AvaliacaoMedica avaliacao) {
        avaliacaoMedicaDao.registrar(avaliacao);
    }

    // Alterar Avaliação Médica
    public void alterar(AvaliacaoMedica avaliacao) {
        avaliacaoMedicaDao.atualizar(avaliacao);
    }

    // Excluir Avaliação Médica
    public void excluir(AvaliacaoMedica avaliacao) {
        avaliacaoMedicaDao.remover(avaliacao);
    }

    // Consultar Avaliação por Paciente
    public List<AvaliacaoMedica> buscarAvaliacoesPorPaciente(Long pacienteId) {
        return avaliacaoMedicaDao.buscarPorPaciente(pacienteId);
    }

    // Listar Avaliações por Período
    public List<AvaliacaoMedica> buscarAvaliacoesPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return avaliacaoMedicaDao.buscarPorPeriodo(inicio, fim);
    }

    // Listar Avaliações por Profissional
    public List<AvaliacaoMedica> buscarAvaliacoesPorProfissional(Long profissionalId) {
        return avaliacaoMedicaDao.buscarPorProfissional(profissionalId);
    }

    // Listar todas as Avaliações Médicas
    public List<AvaliacaoMedica> buscarTodasAvaliacoes() {
        return avaliacaoMedicaDao.buscarTodos();
    }
}
