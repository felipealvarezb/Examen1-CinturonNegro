package com.felipe.LibreriaAPI.mappers;


import com.felipe.LibreriaAPI.dtos.EditorialDTO;
import com.felipe.LibreriaAPI.dtos.response.EditorialResponseDTO;
import com.felipe.LibreriaAPI.entities.Editorial;

public interface EditorialMapper {

  Editorial editorialDtoToEditorial(EditorialDTO editorialDto);

  EditorialResponseDTO editorialToEditorialResponseDTO(Editorial editorial);
}
