package com.felipe.LibreriaAPI.mappers.implementation;



import com.felipe.LibreriaAPI.dtos.AuthorDTO;
import com.felipe.LibreriaAPI.dtos.BookDTO;
import com.felipe.LibreriaAPI.dtos.EditorialDTO;
import com.felipe.LibreriaAPI.dtos.GenderDTO;
import com.felipe.LibreriaAPI.dtos.response.BookResponseDTO;
import com.felipe.LibreriaAPI.entities.Book;
import com.felipe.LibreriaAPI.entities.BookGenderDetail;
import com.felipe.LibreriaAPI.entities.Gender;
import com.felipe.LibreriaAPI.mappers.BookMapper;
import com.felipe.LibreriaAPI.repositories.AuthorRepository;
import com.felipe.LibreriaAPI.repositories.EditorialRepository;
import com.felipe.LibreriaAPI.repositories.GenderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapperImpl implements BookMapper {

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private EditorialRepository editorialRepository;

  @Autowired
  private GenderRepository genderRepository;

  @Override
  public Book bookDtoToBook(BookDTO bookDto) {
    Book book = new Book();
    book.setTitle(bookDto.getTitle());
    book.setDescription(bookDto.getDescription());
    book.setAuthor(authorRepository.findById(bookDto.getAuthorId())
            .orElseThrow(() -> new EntityNotFoundException("Author not found")));
    book.setEditorial(editorialRepository.findById(bookDto.getEditorialId())
            .orElseThrow(() -> new EntityNotFoundException("Editorial not found")));

    List<BookGenderDetail> bookGenders = bookDto.getGenderIds().stream()
            .map(genderId -> {
              Gender gender = genderRepository.findById(genderId)
                      .orElseThrow(() -> new EntityNotFoundException("Gender not found"));
              return new BookGenderDetail(null,book, gender);
            }).collect(Collectors.toList());

    book.setBookGenders(bookGenders);
    return book;
  }

  @Override
  public BookResponseDTO bookToBookResponseDto(Book book) {
    BookResponseDTO bookResponseDTO = new BookResponseDTO();
    bookResponseDTO.setId(book.getId());
    bookResponseDTO.setTitle(book.getTitle());
    bookResponseDTO.setDescription(book.getDescription());
    bookResponseDTO.setAuthor(
            new AuthorDTO(
                    book.getAuthor().getName(),
                    book.getAuthor().getNationality(),
                    book.getAuthor().getAge()
            ));
    bookResponseDTO.setEditorial(
            new EditorialDTO(
                    book.getEditorial().getName(),
                    book.getEditorial().getCountry()
            ));
    bookResponseDTO.setGenders(
      book.getBookGenders().stream()
              .map(bookGenderDetail -> new GenderDTO(
                      bookGenderDetail.getGender().getName()
              )).collect(Collectors.toList())
    );
    bookResponseDTO.setCreatedAt(book.getCreatedAt());
    bookResponseDTO.setUpdatedAt(book.getUpdatedAt());
    return bookResponseDTO;
  }

  @Override
  public List<BookResponseDTO> listBookToListBookResponseDto(List<Book> books) {
    return books.stream()
            .map(this::bookToBookResponseDto)
            .collect(Collectors.toList());
  }
}
