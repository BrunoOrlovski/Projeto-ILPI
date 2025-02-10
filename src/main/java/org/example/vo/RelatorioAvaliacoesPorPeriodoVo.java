package org.example.vo;

import java.time.LocalDate;

public class RelatorioAvaliacoesPorPeriodoVo {

    private LocalDate dataAvaliacao;
    private String nomePaciente;
    private String nomeProfissional;

    public RelatorioAvaliacoesPorPeriodoVo(LocalDate dataAvaliacao, String nomePaciente, String nomeProfissional) {
        this.dataAvaliacao = dataAvaliacao;
        this.nomePaciente = nomePaciente;
        this.nomeProfissional = nomeProfissional;
    }

    @Override
    public String toString() {
        return "RelatorioAvaliacoesPorPeriodoVo [dataAvaliacao=" + dataAvaliacao + ", nomePaciente=" + nomePaciente
                + ", nomeProfissional=" + nomeProfissional + "]";
    }
}
