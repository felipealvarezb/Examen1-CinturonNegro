package com.felipe.LibreriaAPI.controllers;

import com.felipe.LibreriaAPI.dtos.AuthorDTO;
import com.felipe.LibreriaAPI.dtos.response.AuthorResponseDTO;
import com.felipe.LibreriaAPI.entities.Author;
import com.felipe.LibreriaAPI.mappers.AuthorMapper;
import com.felipe.LibreriaAPI.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

  @Autowired
  AuthorService authorService;

  @Autowired
  AuthorMapper authorMapper;

  @PostMapping
  public ResponseEntity<AuthorResponseDTO> createAuthor(@Validated @RequestBody AuthorDTO authorDTO) {
    Author author = authorMapper.authorDtoToAuthor(authorDTO);

    Author savedAuthor = authorService.createAuthor(author);

    return ResponseEntity.ok().body(authorMapper.authorToAuthorResponseDTO(savedAuthor));
  }

  @PutMapping(value = "/{authorId}")
  public ResponseEntity<AuthorResponseDTO> updateAuthor( @PathVariable Long authorId, @Validated @RequestBody AuthorDTO authorDTO) {
    Author author = authorMapper.authorDtoToAuthor(authorDTO);

    Author updatedAuthor = authorService.updateAuthor(authorId, author);

    return ResponseEntity.ok().body(authorMapper.authorToAuthorResponseDTO(updatedAuthor));
  }

  @DeleteMapping(value = "/{authorId}")
  public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
    authorService.deleteAuthor(authorId);
    return ResponseEntity.ok().build();
  }
}