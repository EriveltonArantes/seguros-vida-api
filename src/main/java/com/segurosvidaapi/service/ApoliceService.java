package com.segurosvidaapi.service;

import com.segurosvidaapi.dto.ApoliceRequestDTO;
import com.segurosvidaapi.dto.ApoliceResponseDTO;
import com.segurosvidaapi.exception.ResourceNotFoundException;
import com.segurosvidaapi.mapper.ApoliceMapper;
import com.segurosvidaapi.model.Apolice;
import com.segurosvidaapi.repository.ApoliceRepository;
import com.segurosvidaapi.repository.SeguradoRepository;
import com.segurosvidaapi.model.Segurado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ApoliceService {

    @Autowired
    private ApoliceRepository repository;

    @Autowired
    private ApoliceMapper mapper;

    @Autowired
    private SeguradoRepository seguradoRepository;

    @Transactional(readOnly = true)
    public List<ApoliceResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ApoliceResponseDTO buscar(Long id) {
        Apolice entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ApoliceResponseDTO criar(ApoliceRequestDTO dto) {
        Apolice entity = mapper.toEntity(dto);
        Segurado segurado = seguradoRepository.findById(dto.getSeguradoId())
            .orElseThrow(() -> new ResourceNotFoundException("Segurado não encontrado com id: " + dto.getSeguradoId()));
        entity.setSegurado(segurado);
        Apolice salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ApoliceResponseDTO atualizar(Long id, ApoliceRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Apolice não encontrado com id: " + id);
        }
        Apolice entity = mapper.toEntity(dto);
        entity.setId(id);
        Segurado segurado = seguradoRepository.findById(dto.getSeguradoId())
            .orElseThrow(() -> new ResourceNotFoundException("Segurado não encontrado com id: " + dto.getSeguradoId()));
        entity.setSegurado(segurado);
        Apolice salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Apolice não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
