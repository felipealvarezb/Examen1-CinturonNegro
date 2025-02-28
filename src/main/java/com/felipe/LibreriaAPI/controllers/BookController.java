package com.felipe.LibreriaAPI.controllers;

import com.felipe.LibreriaAPI.dtos.BookDTO;
import com.felipe.LibreriaAPI.dtos.response.BookResponseDTO;
import com.felipe.LibreriaAPI.entities.Book;
import com.felipe.LibreriaAPI.mappers.BookMapper;
import com.felipe.LibreriaAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private BookMapper bookMapper;

  @GetMapping()
  public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
    List<Book> bookList = bookService.getAllBooks();
    return ResponseEntity.ok().body(bookMapper.listBookToListBookResponseDto(bookList));
  }

  @GetMapping(value = "/author/{authorId}")
  public ResponseEntity<List<BookResponseDTO>> getBookByAuthor(@PathVariable Long authorId) {
    List<Book> bookList = bookService.getBookByAuthor(authorId);
    return ResponseEntity.ok().body(bookMapper.listBookToListBookResponseDto(bookList));
  }

  @GetMapping(value = "/editorial/{editorialId}")
  public ResponseEntity<List<BookResponseDTO>> getBookByEditorial(@PathVariable Long editorialId) {
    List<Book> bookList = bookService.getBookByEditorial(editorialId);
    return ResponseEntity.ok().body(bookMapper.listBookToListBookResponseDto(bookList));
  }

  @GetMapping(value = "/{bookId}")
  public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long bookId) {
    Book book = bookService.getBookById(bookId);
    return ResponseEntity.ok().body(bookMapper.bookToBookResponseDto(book));
  }

  @PostMapping("/{bookId}/gender/{genderId}")
  public ResponseEntity<BookResponseDTO> assignGender(@PathVariable Long bookId, @PathVariable Long genderId) {
    Book book = bookService.assignGender(bookId, genderId);
    return ResponseEntity.ok().body(bookMapper.bookToBookResponseDto(book));
  }

  @DeleteMapping("/{bookId}/gender/{genderId}")
  public ResponseEntity<BookResponseDTO> unassignGender(@PathVariable Long bookId, @PathVariable Long genderId) {
    Book book = bookService.unassignGender(bookId, genderId);
    return ResponseEntity.ok().body(bookMapper.bookToBookResponseDto(book));
  }

  @PostMapping
  public ResponseEntity<BookResponseDTO> createBook(@Validated @RequestBody BookDTO bookDTO) {
    Book book = bookMapper.bookDtoToBook(bookDTO);

    Book savedBook = bookService.createBook(book, bookDTO.getAuthorId(), bookDTO.getEditorialId());

    return ResponseEntity.ok().body(bookMapper.bookToBookResponseDto(savedBook));
  }

  @PutMapping(value = "/{bookId}")
  public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long bookId, @Validated @RequestBody BookDTO bookDTO) {
    Book book = bookMapper.bookDtoToBook(bookDTO);

    Book updatedBook = bookService.updateBook(bookId, book, bookDTO.getAuthorId(), bookDTO.getEditorialId());

    return ResponseEntity.ok().body(bookMapper.bookToBookResponseDto(updatedBook));
  }

  @DeleteMapping(value = "/{bookId}")
  public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
    String message = bookService.deleteBook(bookId);
    return ResponseEntity.ok().body(message);
  }
}
