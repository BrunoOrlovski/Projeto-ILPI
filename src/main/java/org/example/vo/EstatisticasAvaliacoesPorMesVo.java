package org.example.vo;

public class EstatisticasAvaliacoesPorMesVo {

    private String mesAno;
    private Long totalAvaliacoes;

    public EstatisticasAvaliacoesPorMesVo(String mesAno, Long totalAvaliacoes) {
        this.mesAno = mesAno;
        this.totalAvaliacoes = totalAvaliacoes;
    }

    @Override
    public String toString() {
        return "EstatisticasAvaliacoesPorMesVo [mesAno=" + mesAno + ", totalAvaliacoes=" + totalAvaliacoes + "]";
    }
}
