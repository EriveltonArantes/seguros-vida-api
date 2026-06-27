package com.segurosvidaapi.dto;

import jakarta.validation.constraints.*;

public class BeneficiarioApoliceRequestDTO {

    @NotNull(message = "ApoliceId é obrigatório")
    @Positive(message = "ApoliceId deve ser um ID válido (positivo)")
    private Long apoliceId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "parentesco não pode estar em branco")
    private String parentesco;
    @NotNull(message = "percentual não pode ser nulo")
    private Double percentual;

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
