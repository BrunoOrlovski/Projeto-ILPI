package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.AvaliacaoMedica;

import java.time.LocalDateTime;
import java.util.List;

public class AvaliacaoMedicaDao {

    private EntityManager em;

    public AvaliacaoMedicaDao(EntityManager em) {
        this.em = em;
    }

    // Registrar Avaliação Médica
    public void registrar(AvaliacaoMedica avaliacao) {
        this.em.getTransaction().begin();
        this.em.persist(avaliacao);
        this.em.getTransaction().commit();
    }

    // Atualizar Avaliação Médica
    public void atualizar(AvaliacaoMedica avaliacao) {
        this.em.getTransaction().begin();
        this.em.merge(avaliacao);
        this.em.getTransaction().commit();
    }

    // Excluir Avaliação Médica
    public void remover(AvaliacaoMedica avaliacao) {
        this.em.getTransaction().begin();
        this.em.remove(avaliacao);
        this.em.getTransaction().commit();
    }

    // Consultar Avaliação Médica por Paciente
    public List<AvaliacaoMedica> buscarPorPaciente(Long pacienteId) {
        String jpql = "SELECT a FROM AvaliacaoMedica a WHERE a.pacienteId = :pacienteId";
        return em.createQuery(jpql, AvaliacaoMedica.class)
                .setParameter("pacienteId", pacienteId)
                .getResultList();
    }

    // Listar Avaliações Médicas por Período
    public List<AvaliacaoMedica> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        String jpql = "SELECT a FROM AvaliacaoMedica a WHERE a.data BETWEEN :inicio AND :fim";
        return em.createQuery(jpql, AvaliacaoMedica.class)
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .getResultList();
    }

    // Listar Avaliações Médicas por Profissional
    public List<AvaliacaoMedica> buscarPorProfissional(Long profissionalId) {
        String jpql = "SELECT a FROM AvaliacaoMedica a WHERE a.profissionalId = :profissionalId";
        return em.createQuery(jpql, AvaliacaoMedica.class)
                .setParameter("profissionalId", profissionalId)
                .getResultList();
    }

    // Listar todas as Avaliações Médicas
    public List<AvaliacaoMedica> buscarTodos() {
        String jpql = "SELECT a FROM AvaliacaoMedica a";
        return em.createQuery(jpql, AvaliacaoMedica.class).getResultList();
    }
}
