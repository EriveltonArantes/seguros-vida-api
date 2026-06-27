package com.segurosvidaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiarioapolices")
public class BeneficiarioApolice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apolice_id")
    private Apolice apolice;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String parentesco;
    private Double percentual;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Apolice getApolice() { return apolice; }
    public void setApolice(Apolice apolice) { this.apolice = apolice; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getParentesco() { return parentesco; }
    public void setParentesco(String parentesco) { this.parentesco = parentesco; }
    public Double getPercentual() { return percentual; }
    public void setPercentual(Double percentual) { this.percentual = percentual; }
}
