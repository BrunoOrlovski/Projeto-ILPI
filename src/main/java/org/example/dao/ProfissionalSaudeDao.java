package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.ProfissionalSaude;

import java.util.List;

public class ProfissionalSaudeDao {

    private EntityManager em;

    public ProfissionalSaudeDao(EntityManager em) {
        this.em = em;
    }

    // Cadastrar Profissional
    public void cadastrar(ProfissionalSaude profissional) {
        this.em.getTransaction().begin();
        this.em.persist(profissional);
        this.em.getTransaction().commit();
    }

    // Atualizar dados do Profissional
    public void atualizar(ProfissionalSaude profissional) {
        this.em.getTransaction().begin();
        this.em.merge(profissional);
        this.em.getTransaction().commit();
    }

    // Excluir Profissional
    public void remover(ProfissionalSaude profissional) {
        this.em.getTransaction().begin();
        this.em.remove(profissional);
        this.em.getTransaction().commit();
    }

    // Consultar Profissional por Registro
    public ProfissionalSaude buscarPorRegistro(String registro) {
        String jpql = "SELECT p FROM ProfissionalSaude p WHERE p.registro = :registro";
        return em.createQuery(jpql, ProfissionalSaude.class)
                .setParameter("registro", registro)
                .getSingleResult();
    }

    // Consultar Profissional por Especialidade
    public List<ProfissionalSaude> buscarPorEspecialidade(String especialidade) {
        String jpql = "SELECT p FROM ProfissionalSaude p WHERE p.especialidade = :especialidade";
        return em.createQuery(jpql, ProfissionalSaude.class)
                .setParameter("especialidade", especialidade)
                .getResultList();
    }

    // Listar todos os Profissionais
    public List<ProfissionalSaude> buscarTodos() {
        String jpql = "SELECT p FROM ProfissionalSaude p";
        return em.createQuery(jpql, ProfissionalSaude.class).getResultList();
    }
}
