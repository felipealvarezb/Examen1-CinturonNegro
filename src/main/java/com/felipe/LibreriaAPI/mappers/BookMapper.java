package com.felipe.LibreriaAPI.mappers;

import com.felipe.LibreriaAPI.dtos.BookDTO;
import com.felipe.LibreriaAPI.dtos.response.BookResponseDTO;
import com.felipe.LibreriaAPI.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface BookMapper {

  @Mapping(target = "author", ignore = true)
  @Mapping(target = "editorial", ignore = true)
  Book bookDtoToBook(BookDTO bookDTO);

  BookResponseDTO bookToBookResponseDTO(Book book);

  List<Book> listBookDtoToListBook(List<BookDTO> listBookDto);

  List<BookResponseDTO> listBookToListBookResponseDTO(List<Book> listBook);
}
