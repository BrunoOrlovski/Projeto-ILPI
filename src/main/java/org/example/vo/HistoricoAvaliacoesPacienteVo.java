package org.example.vo;

import java.time.LocalDate;

public class HistoricoAvaliacoesPacienteVo {

    private String nomePaciente;
    private LocalDate dataAvaliacao;
    private String descricaoAvaliacao;

    public HistoricoAvaliacoesPacienteVo(String nomePaciente, LocalDate dataAvaliacao, String descricaoAvaliacao) {
        this.nomePaciente = nomePaciente;
        this.dataAvaliacao = dataAvaliacao;
        this.descricaoAvaliacao = descricaoAvaliacao;
    }

    @Override
    public String toString() {
        return "HistoricoAvaliacoesPacienteVo [nomePaciente=" + nomePaciente + ", dataAvaliacao=" + dataAvaliacao
                + ", descricaoAvaliacao=" + descricaoAvaliacao + "]";
    }
}
