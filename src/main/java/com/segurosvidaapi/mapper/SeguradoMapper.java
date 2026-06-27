package com.segurosvidaapi.mapper;

import com.segurosvidaapi.dto.SeguradoRequestDTO;
import com.segurosvidaapi.dto.SeguradoResponseDTO;
import com.segurosvidaapi.model.Segurado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeguradoMapper {

    Segurado toEntity(SeguradoRequestDTO dto);

    SeguradoResponseDTO toResponseDTO(Segurado entity);
}
