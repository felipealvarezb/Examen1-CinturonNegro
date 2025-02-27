package com.felipe.LibreriaAPI.mappers;


import com.felipe.LibreriaAPI.dtos.GenderDTO;
import com.felipe.LibreriaAPI.dtos.response.GenderResponseDTO;
import com.felipe.LibreriaAPI.entities.Gender;

public interface GenderMapper {

  Gender genderDtoToGender(GenderDTO genderDto);

  GenderResponseDTO genderToGenderResponseDTO(Gender gender);
}
