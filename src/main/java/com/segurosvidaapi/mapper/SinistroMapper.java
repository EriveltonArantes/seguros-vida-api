package com.segurosvidaapi.mapper;

import com.segurosvidaapi.dto.SinistroRequestDTO;
import com.segurosvidaapi.dto.SinistroResponseDTO;
import com.segurosvidaapi.model.Sinistro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SinistroMapper {

    @Mapping(target = "apolice", ignore = true)
    Sinistro toEntity(SinistroRequestDTO dto);

    @Mapping(target = "apoliceId", source = "apolice.id")
    SinistroResponseDTO toResponseDTO(Sinistro entity);
}
