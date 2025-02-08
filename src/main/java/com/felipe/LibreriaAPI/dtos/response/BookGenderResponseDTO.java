package com.felipe.LibreriaAPI.dtos.response;

import com.felipe.LibreriaAPI.entities.Book;
import com.felipe.LibreriaAPI.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGenderResponseDTO {
  private Long bookGenderId;

  private Book book;

  private Gender gender;

  private Date createdAt;

  private Date updatedAt;
}
