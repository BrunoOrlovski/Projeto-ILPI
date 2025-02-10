package org.example.vo;

public class RelatorioProfissionaisEPacientesAtendidosVo {

    private String nomeProfissional;
    private String nomePaciente;
    private Long totalAtendimentos;

    public RelatorioProfissionaisEPacientesAtendidosVo(String nomeProfissional, String nomePaciente, Long totalAtendimentos) {
        this.nomeProfissional = nomeProfissional;
        this.nomePaciente = nomePaciente;
        this.totalAtendimentos = totalAtendimentos;
    }

    @Override
    public String toString() {
        return "RelatorioProfissionaisEPacientesAtendidosVo [nomeProfissional=" + nomeProfissional + ", nomePaciente=" + nomePaciente
                + ", totalAtendimentos=" + totalAtendimentos + "]";
    }
}
