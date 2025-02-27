package com.felipe.LibreriaAPI.mappers;


import com.felipe.LibreriaAPI.dtos.AuthorDTO;
import com.felipe.LibreriaAPI.dtos.response.AuthorResponseDTO;
import com.felipe.LibreriaAPI.entities.Author;

public interface AuthorMapper {

  Author authorDtoToAuthor(AuthorDTO authorDto);

  AuthorResponseDTO authorToAuthorResponseDTO(Author author);
}
