package com.felipe.LibreriaAPI.services.Implementation;

import com.felipe.LibreriaAPI.dtos.BookDTO;
import com.felipe.LibreriaAPI.entities.*;
import com.felipe.LibreriaAPI.repositories.*;
import com.felipe.LibreriaAPI.services.BookService;
import jakarta.persistence.EntityNotFoundException;
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

  @Autowired
  private BookGenderDetailRepository bookGenderDetailRepository;

  @Autowired
  private GenderRepository genderRepository;

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
  public Book assignGender(Long bookId, Long genderId) {
    Gender existingGender = genderRepository.findById(genderId)
            .orElseThrow(() -> new EntityNotFoundException("Gender not found"));

    Book existingBook = bookRepository.findById(bookId)
            .orElseThrow(() -> new EntityNotFoundException("Book not found"));

    boolean genderAlreadyAssigned = bookGenderDetailRepository
            .existsByBookIdAndGenderId(bookId, genderId);

    if (genderAlreadyAssigned) {
      throw new IllegalArgumentException("Gender already assigned to the book");
    }

    BookGenderDetail bookGenderDetail = new BookGenderDetail();
    bookGenderDetail.setBook(existingBook);
    bookGenderDetail.setGender(existingGender);

    existingBook.getBookGenders().add(bookGenderDetail);
    bookRepository.save(existingBook);
    return existingBook;
  }

  @Override
  public Book unassignGender(Long bookId, Long genderId) {
    Book existingBook = bookRepository.findById(bookId)
            .orElseThrow(() -> new EntityNotFoundException("Book not found"));

    Gender existingGender = genderRepository.findById(genderId)
            .orElseThrow(() -> new EntityNotFoundException("Gender not found"));

    BookGenderDetail bookGenderDetail = bookGenderDetailRepository
            .findByBookIdAndGenderId(bookId, genderId);

    if (bookGenderDetail == null) {
      throw new IllegalArgumentException("Gender not assigned to the book");
    }

    bookGenderDetailRepository.delete(bookGenderDetail);
    return existingBook;
  }

  @Override
  public Book getBookById(Long id) {
    Book existingBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
    return existingBook;
  }

  @Override
  public Book createBook(Book book, Long idAuthor, Long idEditorial) {
    Author existingAuthor = authorRepository.findById(idAuthor).orElseThrow(() -> new EntityNotFoundException("Author not found"));
    Editorial existingEditorial = editorialRepository.findById(idEditorial).orElseThrow(() -> new EntityNotFoundException("Editorial not found"));
    book.setAuthor(existingAuthor);
    book.setEditorial(existingEditorial);
    Book savedBook = bookRepository.save(book);
    return savedBook;
  }

  @Override
  public Book updateBook(Long id, Book book, Long idAuthor, Long idEditorial) {
    Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    Author existingAuthor = authorRepository.findById(idAuthor).orElseThrow(() -> new EntityNotFoundException("Author not found"));
    Editorial existingEditorial = editorialRepository.findById(idEditorial).orElseThrow(() -> new EntityNotFoundException("Editorial not found"));
    existingBook.setTitle(book.getTitle());
    existingBook.setDescription(book.getDescription());
    existingBook.setAuthor(existingAuthor);
    existingBook.setEditorial(existingEditorial);
    Book updatedBook = bookRepository.save(existingBook);
    return updatedBook;
  }

  @Override
  public String deleteBook(Long id) {
    Book existingBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
    bookRepository.delete(existingBook);
    return "Book deleted successfully";
  }
}
