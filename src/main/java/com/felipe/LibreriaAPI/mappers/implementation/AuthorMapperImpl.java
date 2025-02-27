package com.felipe.LibreriaAPI.mappers.implementation;


import com.felipe.LibreriaAPI.dtos.AuthorDTO;
import com.felipe.LibreriaAPI.dtos.response.AuthorResponseDTO;
import com.felipe.LibreriaAPI.entities.Author;
import com.felipe.LibreriaAPI.mappers.AuthorMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {

  @Override
  public Author authorDtoToAuthor(AuthorDTO authorDto) {
    Author author = new Author();
    author.setName(authorDto.getName());
    author.setNationality(authorDto.getNationality());
    author.setAge(authorDto.getAge());
    return author;
  }

  @Override
  public AuthorResponseDTO authorToAuthorResponseDTO(Author author) {
    AuthorResponseDTO authorResponseDTO = new AuthorResponseDTO();
    authorResponseDTO.setId(author.getId());
    authorResponseDTO.setName(author.getName());
    authorResponseDTO.setNationality(author.getNationality());
    authorResponseDTO.setAge(author.getAge());
    authorResponseDTO.setCreatedAt(author.getCreatedAt());
    authorResponseDTO.setUpdatedAt(author.getUpdatedAt());
    return authorResponseDTO;
  }
}
