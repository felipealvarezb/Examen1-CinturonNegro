package com.felipe.LibreriaAPI.services.Implementation;

import com.felipe.LibreriaAPI.dtos.BookDTO;
import com.felipe.LibreriaAPI.entities.Author;
import com.felipe.LibreriaAPI.entities.Book;
import com.felipe.LibreriaAPI.entities.Editorial;
import com.felipe.LibreriaAPI.repositories.AuthorRepository;
import com.felipe.LibreriaAPI.repositories.BookRepository;
import com.felipe.LibreriaAPI.repositories.EditorialRepository;
import com.felipe.LibreriaAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  BookRepository bookRepository;

  @Autowired
  EditorialRepository editorialRepository;

  @Autowired
  AuthorRepository authorRepository;

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public List<Book> getBookByAuthor(Long idAuthor) {
    return bookRepository.findByAuthorId(idAuthor);
  }

  @Override
  public List<Book> getBookByEditorial(Long idEditorial) {
    return bookRepository.findByEditorialId(idEditorial);
  }

  @Override
  public Book getBookById(Long id) {
    Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    return existingBook;
  }

  @Override
  public Book createBook(Book book, Long idAuthor, Long idEditorial) {
    Author existingAuthor = authorRepository.findById(idAuthor).orElseThrow(() -> new RuntimeException("Author not found"));
    Editorial existingEditorial = editorialRepository.findById(idEditorial).orElseThrow(() -> new RuntimeException("Editorial not found"));
    book.setAuthor(existingAuthor);
    book.setEditorial(existingEditorial);
    Book savedBook = bookRepository.save(book);
    return savedBook;
  }

  @Override
  public Book updateBook(Long id, Book book, Long idAuthor, Long idEditorial) {
    Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    Author existingAuthor = authorRepository.findById(idAuthor).orElseThrow(() -> new RuntimeException("Author not found"));
    Editorial existingEditorial = editorialRepository.findById(idEditorial).orElseThrow(() -> new RuntimeException("Editorial not found"));
    existingBook.setTitle(book.getTitle());
    existingBook.setDescription(book.getDescription());
    existingBook.setAuthor(existingAuthor);
    existingBook.setEditorial(existingEditorial);
    Book updatedBook = bookRepository.save(existingBook);
    return updatedBook;
  }

  @Override
  public void deleteBook(Long id) {
    Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    bookRepository.delete(existingBook);
  }
}
