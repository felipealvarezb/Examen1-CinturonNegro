package com.felipe.LibreriaAPI.mappers.implementation;


import com.felipe.LibreriaAPI.dtos.EditorialDTO;
import com.felipe.LibreriaAPI.dtos.response.EditorialResponseDTO;
import com.felipe.LibreriaAPI.entities.Editorial;
import com.felipe.LibreriaAPI.mappers.EditorialMapper;
import org.springframework.stereotype.Component;

@Component
public class EditorialMapperImpl implements EditorialMapper {
  @Override
  public Editorial editorialDtoToEditorial(EditorialDTO editorialDto) {
    Editorial editorial = new Editorial();
    editorial.setName(editorialDto.getName());
    editorial.setCountry(editorialDto.getCountry());
    return editorial;
  }

  @Override
  public EditorialResponseDTO editorialToEditorialResponseDTO(Editorial editorial) {
    EditorialResponseDTO editorialResponseDTO = new EditorialResponseDTO();
    editorialResponseDTO.setName(editorial.getName());
    editorialResponseDTO.setCountry(editorial.getCountry());
    editorialResponseDTO.setCreatedAt(editorial.getCreatedAt());
    editorialResponseDTO.setUpdatedAt(editorial.getUpdatedAt());
    return editorialResponseDTO;
  }
}
