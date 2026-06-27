package com.segurosvidaapi.controller;

import com.segurosvidaapi.dto.ApoliceRequestDTO;
import com.segurosvidaapi.dto.ApoliceResponseDTO;
import com.segurosvidaapi.service.ApoliceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Apolice", description = "Gerenciamento de apolices")
@RestController
@RequestMapping("/api/apolices")
public class ApoliceController {

    @Autowired
    private ApoliceService service;

    @Operation(summary = "Listar todos os Apolice")
    @GetMapping
    public List<ApoliceResponseDTO> listar(@RequestParam(required = false) String tipo, @RequestParam(required = false) Long seguradoId) {
        List<ApoliceResponseDTO> resultado = service.listar();
        if (tipo != null && !tipo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTipo() != null &&
                item.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (seguradoId != null) {
            resultado = resultado.stream().filter(item -> seguradoId.equals(item.getSeguradoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Apolice por ID")
    @GetMapping("/{id}")
    public ApoliceResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Apolice")
    @PostMapping
    public ResponseEntity<ApoliceResponseDTO> criar(@Valid @RequestBody ApoliceRequestDTO apolice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(apolice));
    }

    @Operation(summary = "Atualizar Apolice")
    @PutMapping("/{id}")
    public ApoliceResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ApoliceRequestDTO apolice) {
        return service.atualizar(id, apolice);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Apolice")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
