package com.felipe.LibreriaAPI.services;

import com.felipe.LibreriaAPI.entities.Author;

public interface AuthorService {

  Author createAuthor(Author author);

  Author updateAuthor(Long id, Author author);

  void deleteAuthor(Long id);

}
