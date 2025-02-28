package com.felipe.LibreriaAPI.services;

import com.felipe.LibreriaAPI.entities.Author;

public interface AuthorService {

  Author createAuthor(Author author);

  Author updateAuthor(Long id, Author author);

  String deleteAuthor(Long id);

}
