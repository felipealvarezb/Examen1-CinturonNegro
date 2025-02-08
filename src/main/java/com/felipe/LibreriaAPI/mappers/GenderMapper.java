package com.felipe.LibreriaAPI.mappers;

import com.felipe.LibreriaAPI.dtos.GenderDTO;
import com.felipe.LibreriaAPI.dtos.response.GenderResponseDTO;
import com.felipe.LibreriaAPI.entities.Gender;
import org.mapstruct.Mapper;

@Mapper
public interface GenderMapper {

  Gender gentDtoToGender(GenderDTO genderDTO);

  GenderResponseDTO genderToGenderResponseDTO(Gender gender);
}
