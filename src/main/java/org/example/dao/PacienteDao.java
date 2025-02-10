package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Paciente;

import java.util.List;

public class PacienteDao {

    private EntityManager em;

    public PacienteDao(EntityManager em) {
        this.em = em;
    }

    // Cadastrar Paciente
    public void cadastrar(Paciente paciente) {
        this.em.getTransaction().begin();
        this.em.persist(paciente);
        this.em.getTransaction().commit();
    }

    // Atualizar dados do Paciente
    public void atualizar(Paciente paciente) {
        this.em.getTransaction().begin();
        this.em.merge(paciente);
        this.em.getTransaction().commit();
    }

    // Excluir Paciente
    public void remover(Paciente paciente) {
        this.em.getTransaction().begin();
        this.em.remove(paciente);
        this.em.getTransaction().commit();
    }

    // Consultar Paciente por ID
    public Paciente buscarPorId(Long id) {
        return em.find(Paciente.class, id);
    }

    // Consultar Paciente por CPF
    public Paciente buscarPorCpf(String cpf) {
        String jpql = "SELECT p FROM Paciente p WHERE p.cpf = :cpf";
        return em.createQuery(jpql, Paciente.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }

    // Listar todos os Pacientes
    public List<Paciente> buscarTodos() {
        String jpql = "SELECT p FROM Paciente p";
        return em.createQuery(jpql, Paciente.class).getResultList();
    }
}
