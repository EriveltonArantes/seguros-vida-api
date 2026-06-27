package com.segurosvidaapi.controller;

import com.segurosvidaapi.dto.SeguradoRequestDTO;
import com.segurosvidaapi.dto.SeguradoResponseDTO;
import com.segurosvidaapi.service.SeguradoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Segurado", description = "Gerenciamento de segurados")
@RestController
@RequestMapping("/api/segurados")
public class SeguradoController {

    @Autowired
    private SeguradoService service;

    @Operation(summary = "Listar todos os Segurado")
    @GetMapping
    public List<SeguradoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<SeguradoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Segurado por ID")
    @GetMapping("/{id}")
    public SeguradoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Segurado")
    @PostMapping
    public ResponseEntity<SeguradoResponseDTO> criar(@Valid @RequestBody SeguradoRequestDTO segurado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(segurado));
    }

    @Operation(summary = "Atualizar Segurado")
    @PutMapping("/{id}")
    public SeguradoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody SeguradoRequestDTO segurado) {
        return service.atualizar(id, segurado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Segurado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
