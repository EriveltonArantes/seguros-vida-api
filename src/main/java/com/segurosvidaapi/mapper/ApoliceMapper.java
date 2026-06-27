package com.segurosvidaapi.mapper;

import com.segurosvidaapi.dto.ApoliceRequestDTO;
import com.segurosvidaapi.dto.ApoliceResponseDTO;
import com.segurosvidaapi.model.Apolice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApoliceMapper {

    @Mapping(target = "segurado", ignore = true)
    Apolice toEntity(ApoliceRequestDTO dto);

    @Mapping(target = "seguradoId", source = "segurado.id")
    ApoliceResponseDTO toResponseDTO(Apolice entity);
}
