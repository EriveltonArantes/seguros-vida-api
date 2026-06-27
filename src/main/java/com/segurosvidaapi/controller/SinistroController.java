package com.segurosvidaapi.controller;

import com.segurosvidaapi.dto.SinistroRequestDTO;
import com.segurosvidaapi.dto.SinistroResponseDTO;
import com.segurosvidaapi.service.SinistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Sinistro", description = "Gerenciamento de sinistros")
@RestController
@RequestMapping("/api/sinistros")
public class SinistroController {

    @Autowired
    private SinistroService service;

    @Operation(summary = "Listar todos os Sinistro")
    @GetMapping
    public List<SinistroResponseDTO> listar(@RequestParam(required = false) String descricao, @RequestParam(required = false) Long apoliceId) {
        List<SinistroResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (apoliceId != null) {
            resultado = resultado.stream().filter(item -> apoliceId.equals(item.getApoliceId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Sinistro por ID")
    @GetMapping("/{id}")
    public SinistroResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Sinistro")
    @PostMapping
    public ResponseEntity<SinistroResponseDTO> criar(@Valid @RequestBody SinistroRequestDTO sinistro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(sinistro));
    }

    @Operation(summary = "Atualizar Sinistro")
    @PutMapping("/{id}")
    public SinistroResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody SinistroRequestDTO sinistro) {
        return service.atualizar(id, sinistro);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Sinistro")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
