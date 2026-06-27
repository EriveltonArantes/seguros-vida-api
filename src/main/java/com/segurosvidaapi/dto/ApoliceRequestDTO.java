package com.segurosvidaapi.dto;

import jakarta.validation.constraints.*;

public class ApoliceRequestDTO {

    @NotNull(message = "SeguradoId é obrigatório")
    @Positive(message = "SeguradoId deve ser um ID válido (positivo)")
    private Long seguradoId;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotNull(message = "vigencia inicio não pode ser nulo")
    private java.time.LocalDateTime vigenciaInicio;
    @NotNull(message = "vigencia fim não pode ser nulo")
    private java.time.LocalDateTime vigenciaFim;
    @NotNull(message = "capital segurado não pode ser nulo")
    private Double capitalSegurado;
    @NotNull(message = "premio não pode ser nulo")
    private java.math.BigDecimal premio;
    @NotBlank(message = "periodicidade não pode estar em branco")
    private String periodicidade;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getSeguradoId() { return seguradoId; }
    public void setSeguradoId(Long seguradoId) { this.seguradoId = seguradoId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public java.time.LocalDateTime getVigenciaInicio() { return vigenciaInicio; }
    public void setVigenciaInicio(java.time.LocalDateTime vigenciaInicio) { this.vigenciaInicio = vigenciaInicio; }
    public java.time.LocalDateTime getVigenciaFim() { return vigenciaFim; }
    public void setVigenciaFim(java.time.LocalDateTime vigenciaFim) { this.vigenciaFim = vigenciaFim; }
    public Double getCapitalSegurado() { return capitalSegurado; }
    public void setCapitalSegurado(Double capitalSegurado) { this.capitalSegurado = capitalSegurado; }
    public java.math.BigDecimal getPremio() { return premio; }
    public void setPremio(java.math.BigDecimal premio) { this.premio = premio; }
    public String getPeriodicidade() { return periodicidade; }
    public void setPeriodicidade(String periodicidade) { this.periodicidade = periodicidade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
