package com.segurosvidaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apolices")
public class Apolice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "segurado_id")
    private Segurado segurado;
    @Column(nullable = false)
    private String tipo;
    private java.time.LocalDateTime vigenciaInicio;
    private java.time.LocalDateTime vigenciaFim;
    private Double capitalSegurado;
    private java.math.BigDecimal premio;
    @Column(nullable = false)
    private String periodicidade;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Segurado getSegurado() { return segurado; }
    public void setSegurado(Segurado segurado) { this.segurado = segurado; }
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
