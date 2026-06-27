package com.segurosvidaapi.service;

import com.segurosvidaapi.dto.BeneficiarioApoliceRequestDTO;
import com.segurosvidaapi.dto.BeneficiarioApoliceResponseDTO;
import com.segurosvidaapi.exception.ResourceNotFoundException;
import com.segurosvidaapi.mapper.BeneficiarioApoliceMapper;
import com.segurosvidaapi.model.BeneficiarioApolice;
import com.segurosvidaapi.repository.BeneficiarioApoliceRepository;
import com.segurosvidaapi.repository.ApoliceRepository;
import com.segurosvidaapi.model.Apolice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BeneficiarioApoliceService {

    @Autowired
    private BeneficiarioApoliceRepository repository;

    @Autowired
    private BeneficiarioApoliceMapper mapper;

    @Autowired
    private ApoliceRepository apoliceRepository;

    @Transactional(readOnly = true)
    public List<BeneficiarioApoliceResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BeneficiarioApoliceResponseDTO buscar(Long id) {
        BeneficiarioApolice entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("BeneficiarioApolice não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public BeneficiarioApoliceResponseDTO criar(BeneficiarioApoliceRequestDTO dto) {
        BeneficiarioApolice entity = mapper.toEntity(dto);
        Apolice apolice = apoliceRepository.findById(dto.getApoliceId())
            .orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado com id: " + dto.getApoliceId()));
        entity.setApolice(apolice);
        BeneficiarioApolice salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public BeneficiarioApoliceResponseDTO atualizar(Long id, BeneficiarioApoliceRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("BeneficiarioApolice não encontrado com id: " + id);
        }
        BeneficiarioApolice entity = mapper.toEntity(dto);
        entity.setId(id);
        Apolice apolice = apoliceRepository.findById(dto.getApoliceId())
            .orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado com id: " + dto.getApoliceId()));
        entity.setApolice(apolice);
        BeneficiarioApolice salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("BeneficiarioApolice não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
