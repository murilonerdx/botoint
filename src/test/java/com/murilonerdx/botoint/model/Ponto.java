package com.murilonerdx.botoint.model;

public class Ponto {
    private String ponto;
    private String LocalDateTime;
    private String descricao;

    public Ponto(String ponto, String localDateTime, String descricao) {
        this.ponto = ponto;
        LocalDateTime = localDateTime;
        this.descricao = descricao;
    }

    public String getPonto() {
        return ponto;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
    }

    public String getLocalDateTime() {
        return LocalDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        LocalDateTime = localDateTime;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Ponto{" +
                "categoria do ponto='" + ponto + '\'' +
                ", horario do ponto ='" + LocalDateTime + '\'' +
                ", descricao do ponto='" + descricao + '\'' +
                '}';
    }
}
