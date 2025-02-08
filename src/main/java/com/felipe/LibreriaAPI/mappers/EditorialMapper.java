package com.felipe.LibreriaAPI.mappers;

import com.felipe.LibreriaAPI.dtos.EditorialDTO;
import com.felipe.LibreriaAPI.dtos.response.EditorialResponseDTO;
import com.felipe.LibreriaAPI.entities.Editorial;
import org.mapstruct.Mapper;

@Mapper
public interface EditorialMapper {

  Editorial editorialDTOToEditorial(EditorialDTO editorialDTO);

  EditorialResponseDTO editorialToEditorialResponseDTO(Editorial editorial);

}
