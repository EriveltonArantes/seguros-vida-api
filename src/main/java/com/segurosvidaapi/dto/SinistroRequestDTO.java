package com.segurosvidaapi.dto;

import jakarta.validation.constraints.*;

public class SinistroRequestDTO {

    @NotNull(message = "ApoliceId é obrigatório")
    @Positive(message = "ApoliceId deve ser um ID válido (positivo)")
    private Long apoliceId;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotNull(message = "data ocorrencia não pode ser nulo")
    private java.time.LocalDateTime dataOcorrencia;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @DecimalMin(value = "0.0", message = "valor reivindicado não pode ser negativo")
    @NotNull(message = "valor reivindicado não pode ser nulo")
    private Double valorReivindicado;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
