package com.felipe.LibreriaAPI.repositories;

import com.felipe.LibreriaAPI.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  @Query("SELECT b FROM Book b WHERE b.author.id = :authorId")
  List<Book> findByAuthorId(Long authorId);

  @Query("SELECT b FROM Book b WHERE b.editorial.id = :editorialId")
  List<Book> findByEditorialId(Long editorialId);
}
