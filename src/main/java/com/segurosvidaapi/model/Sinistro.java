package com.segurosvidaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sinistros")
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apolice_id")
    private Apolice apolice;
    @Column(nullable = false)
    private String tipo;
    private java.time.LocalDateTime dataOcorrencia;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private Double valorReivindicado;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Apolice getApolice() { return apolice; }
    public void setApolice(Apolice apolice) { this.apolice = apolice; }
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
