package com.felipe.LibreriaAPI.mappers;

import com.felipe.LibreriaAPI.dtos.response.BookGenderResponseDTO;
import com.felipe.LibreriaAPI.entities.BookGenderDetail;
import org.mapstruct.Mapper;

@Mapper
public interface BookGenderDetailMapper {

  BookGenderResponseDTO bookGenderDetailToBookGenderDetailResponseDTO(BookGenderDetail bookGenderDetail);
}
