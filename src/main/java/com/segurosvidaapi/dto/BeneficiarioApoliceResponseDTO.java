package com.segurosvidaapi.dto;

public class BeneficiarioApoliceResponseDTO {

    private Long id;
    private Long apoliceId;
    private String nome;
    private String cpf;
    private String parentesco;
    private Double percentual;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getApoliceId() { return apoliceId; }
    public void setApoliceId(Long apoliceId) { this.apoliceId = apoliceId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getParentesco() { return parentesco; }
    public void setParentesco(String parentesco) { this.parentesco = parentesco; }
    public Double getPercentual() { return percentual; }
    public void setPercentual(Double percentual) { this.percentual = percentual; }
}
