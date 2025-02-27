package com.felipe.LibreriaAPI.mappers.implementation;


import com.felipe.LibreriaAPI.dtos.GenderDTO;
import com.felipe.LibreriaAPI.dtos.response.GenderResponseDTO;
import com.felipe.LibreriaAPI.entities.Gender;
import com.felipe.LibreriaAPI.mappers.GenderMapper;
import org.springframework.stereotype.Component;

@Component
public class GenderMapperImpl implements GenderMapper {

  @Override
  public Gender genderDtoToGender(GenderDTO genderDto) {
    Gender gender = new Gender();
    gender.setName(genderDto.getName());
    return gender;
  }

  @Override
  public GenderResponseDTO genderToGenderResponseDTO(Gender gender) {
    GenderResponseDTO genderResponseDTO = new GenderResponseDTO();
    genderResponseDTO.setName(gender.getName());
    genderResponseDTO.setCreatedAt(gender.getCreatedAt());
    genderResponseDTO.setUpdatedAt(gender.getUpdatedAt());
    return genderResponseDTO;
  }
}
