package com.segurosvidaapi.dto;

public class ApoliceResponseDTO {

    private Long id;
    private Long seguradoId;
    private String tipo;
    private java.time.LocalDateTime vigenciaInicio;
    private java.time.LocalDateTime vigenciaFim;
    private Double capitalSegurado;
    private java.math.BigDecimal premio;
    private String periodicidade;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
