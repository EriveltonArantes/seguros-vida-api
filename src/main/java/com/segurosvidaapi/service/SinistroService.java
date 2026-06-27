package com.segurosvidaapi.service;

import com.segurosvidaapi.dto.SinistroRequestDTO;
import com.segurosvidaapi.dto.SinistroResponseDTO;
import com.segurosvidaapi.exception.ResourceNotFoundException;
import com.segurosvidaapi.mapper.SinistroMapper;
import com.segurosvidaapi.model.Sinistro;
import com.segurosvidaapi.repository.SinistroRepository;
import com.segurosvidaapi.repository.ApoliceRepository;
import com.segurosvidaapi.model.Apolice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SinistroService {

    @Autowired
    private SinistroRepository repository;

    @Autowired
    private SinistroMapper mapper;

    @Autowired
    private ApoliceRepository apoliceRepository;

    @Transactional(readOnly = true)
    public List<SinistroResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SinistroResponseDTO buscar(Long id) {
        Sinistro entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Sinistro não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public SinistroResponseDTO criar(SinistroRequestDTO dto) {
        Sinistro entity = mapper.toEntity(dto);
        Apolice apolice = apoliceRepository.findById(dto.getApoliceId())
            .orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado com id: " + dto.getApoliceId()));
        entity.setApolice(apolice);
        Sinistro salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public SinistroResponseDTO atualizar(Long id, SinistroRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sinistro não encontrado com id: " + id);
        }
        Sinistro entity = mapper.toEntity(dto);
        entity.setId(id);
        Apolice apolice = apoliceRepository.findById(dto.getApoliceId())
            .orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado com id: " + dto.getApoliceId()));
        entity.setApolice(apolice);
        Sinistro salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sinistro não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
