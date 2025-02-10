package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.ProfissionalSaudeDao;
import org.example.model.ProfissionalSaude;

import java.util.List;

public class ProfissionalSaudeService {
    private ProfissionalSaudeDao profissionalSaudeDao;

    public ProfissionalSaudeService(EntityManager em) {
        profissionalSaudeDao = new ProfissionalSaudeDao(em);
    }

    // Inserir Profissional
    public void inserir(ProfissionalSaude profissional) {
        profissionalSaudeDao.cadastrar(profissional);
    }

    // Alterar dados do Profissional
    public void alterar(ProfissionalSaude profissional) {
        profissionalSaudeDao.atualizar(profissional);
    }

    // Excluir Profissional
    public void excluir(ProfissionalSaude profissional) {
        profissionalSaudeDao.remover(profissional);
    }

    // Consultar Profissional por Registro
    public ProfissionalSaude buscarProfissionalPorRegistro(String registro) {
        return profissionalSaudeDao.buscarPorRegistro(registro);
    }

    // Consultar Profissional por Especialidade
    public List<ProfissionalSaude> buscarProfissionaisPorEspecialidade(String especialidade) {
        return profissionalSaudeDao.buscarPorEspecialidade(especialidade);
    }

    // Listar todos os Profissionais
    public List<ProfissionalSaude> buscarTodosOsProfissionais() {
        return profissionalSaudeDao.buscarTodos();
    }
}
