package com.segurosvidaapi.dto;

public class SinistroResponseDTO {

    private Long id;
    private Long apoliceId;
    private String tipo;
    private java.time.LocalDateTime dataOcorrencia;
    private String descricao;
    private Double valorReivindicado;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getApoliceId() { return apoliceId; }
    public void setApoliceId(Long apoliceId) { this.apoliceId = apoliceId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public java.time.LocalDateTime getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(java.time.LocalDateTime dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getValorReivindicado() { return valorReivindicado; }
    public void setValorReivindicado(Double valorReivindicado) { this.valorReivindicado = valorReivindicado; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
