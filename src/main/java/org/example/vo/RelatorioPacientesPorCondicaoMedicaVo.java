package org.example.vo;


public class RelatorioPacientesPorCondicaoMedicaVo {

    private String nomePaciente;
    private String condicaoMedica;
    private Long totalPacientes;

    public RelatorioPacientesPorCondicaoMedicaVo(String nomePaciente, String condicaoMedica, Long totalPacientes) {
        this.nomePaciente = nomePaciente;
        this.condicaoMedica = condicaoMedica;
        this.totalPacientes = totalPacientes;
    }

    @Override
    public String toString() {
        return "RelatorioPacientesPorCondicaoMedicaVo [nomePaciente=" + nomePaciente + ", condicaoMedica=" + condicaoMedica
                + ", totalPacientes=" + totalPacientes + "]";
    }

}
