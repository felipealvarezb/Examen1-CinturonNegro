package com.felipe.LibreriaAPI.mappers;

import com.felipe.LibreriaAPI.dtos.AuthorDTO;
import com.felipe.LibreriaAPI.dtos.response.AuthorResponseDTO;
import com.felipe.LibreriaAPI.entities.Author;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {

  Author authorDtoToAuthor(AuthorDTO authorDTO);

  AuthorResponseDTO authorToAuthorResponseDTO(Author author);
}
