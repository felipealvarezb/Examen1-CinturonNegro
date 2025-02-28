package com.felipe.LibreriaAPI.services.Implementation;

import com.felipe.LibreriaAPI.entities.Author;
import com.felipe.LibreriaAPI.repositories.AuthorRepository;
import com.felipe.LibreriaAPI.services.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

  @Autowired
  private AuthorRepository authorRepository;
  @Override
  public Author createAuthor(Author author) {
    Author savedAuthor = authorRepository.save(author);
    return savedAuthor;
  }

  @Override
  public Author updateAuthor(Long id, Author author) {
    Author existingAuthor = authorRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Author not found"));

    existingAuthor.setName(author.getName());
    existingAuthor.setNationality(author.getNationality());
    existingAuthor.setAge(author.getAge());

    Author updatedAuthor = authorRepository.save(existingAuthor);
    return updatedAuthor;
  }

  @Override
  public String deleteAuthor(Long id) {
    Author existingAuthor = authorRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Author not found"));

    authorRepository.delete(existingAuthor);

    return "Author deleted successfully";
  }
}
