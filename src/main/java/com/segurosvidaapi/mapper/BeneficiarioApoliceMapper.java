package com.segurosvidaapi.mapper;

import com.segurosvidaapi.dto.BeneficiarioApoliceRequestDTO;
import com.segurosvidaapi.dto.BeneficiarioApoliceResponseDTO;
import com.segurosvidaapi.model.BeneficiarioApolice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BeneficiarioApoliceMapper {

    @Mapping(target = "apolice", ignore = true)
    BeneficiarioApolice toEntity(BeneficiarioApoliceRequestDTO dto);

    @Mapping(target = "apoliceId", source = "apolice.id")
    BeneficiarioApoliceResponseDTO toResponseDTO(BeneficiarioApolice entity);
}
