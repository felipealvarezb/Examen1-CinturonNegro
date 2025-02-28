package com.felipe.LibreriaAPI.mappers;


import com.felipe.LibreriaAPI.dtos.BookDTO;
import com.felipe.LibreriaAPI.dtos.response.BookResponseDTO;
import com.felipe.LibreriaAPI.entities.Book;

import java.util.List;

public interface BookMapper {

  Book bookDtoToBook(BookDTO bookDto);

  BookResponseDTO bookToBookResponseDto(Book book);

  List<BookResponseDTO> listBookToListBookResponseDto(List<Book> books);
}
