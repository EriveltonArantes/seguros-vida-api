package com.segurosvidaapi.controller;

import com.segurosvidaapi.dto.BeneficiarioApoliceRequestDTO;
import com.segurosvidaapi.dto.BeneficiarioApoliceResponseDTO;
import com.segurosvidaapi.service.BeneficiarioApoliceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "BeneficiarioApolice", description = "Gerenciamento de beneficiarioapolices")
@RestController
@RequestMapping("/api/beneficiarioapolices")
public class BeneficiarioApoliceController {

    @Autowired
    private BeneficiarioApoliceService service;

    @Operation(summary = "Listar todos os BeneficiarioApolice")
    @GetMapping
    public List<BeneficiarioApoliceResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long apoliceId) {
        List<BeneficiarioApoliceResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (apoliceId != null) {
            resultado = resultado.stream().filter(item -> apoliceId.equals(item.getApoliceId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar BeneficiarioApolice por ID")
    @GetMapping("/{id}")
    public BeneficiarioApoliceResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar BeneficiarioApolice")
    @PostMapping
    public ResponseEntity<BeneficiarioApoliceResponseDTO> criar(@Valid @RequestBody BeneficiarioApoliceRequestDTO beneficiarioApolice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(beneficiarioApolice));
    }

    @Operation(summary = "Atualizar BeneficiarioApolice")
    @PutMapping("/{id}")
    public BeneficiarioApoliceResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody BeneficiarioApoliceRequestDTO beneficiarioApolice) {
        return service.atualizar(id, beneficiarioApolice);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir BeneficiarioApolice")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
