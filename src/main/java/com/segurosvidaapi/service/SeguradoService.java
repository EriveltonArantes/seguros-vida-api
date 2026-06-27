package com.segurosvidaapi.service;

import com.segurosvidaapi.dto.SeguradoRequestDTO;
import com.segurosvidaapi.dto.SeguradoResponseDTO;
import com.segurosvidaapi.exception.ResourceNotFoundException;
import com.segurosvidaapi.mapper.SeguradoMapper;
import com.segurosvidaapi.model.Segurado;
import com.segurosvidaapi.repository.SeguradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SeguradoService {

    @Autowired
    private SeguradoRepository repository;

    @Autowired
    private SeguradoMapper mapper;

    @Transactional(readOnly = true)
    public List<SeguradoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SeguradoResponseDTO buscar(Long id) {
        Segurado entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Segurado não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public SeguradoResponseDTO criar(SeguradoRequestDTO dto) {
        Segurado entity = mapper.toEntity(dto);
        Segurado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public SeguradoResponseDTO atualizar(Long id, SeguradoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Segurado não encontrado com id: " + id);
        }
        Segurado entity = mapper.toEntity(dto);
        entity.setId(id);
        Segurado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Segurado não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
