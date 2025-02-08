package com.felipe.LibreriaAPI.services;

import com.felipe.LibreriaAPI.dtos.BookDTO;
import com.felipe.LibreriaAPI.entities.Book;

import java.util.List;

public interface BookService {

  List<Book> getAllBooks();

  List<Book> getBookByAuthor(Long idAuthor);

  List<Book> getBookByEditorial(Long idEditorial);

  Book getBookById(Long id);

  Book createBook(Book book, Long authorId, Long editorialId);

  Book updateBook(Long id, Book book, Long authorId, Long editorialId);

  void deleteBook(Long id);
}
