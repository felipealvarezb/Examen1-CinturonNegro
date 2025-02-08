package com.felipe.LibreriaAPI.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDTO {
  private Long authorId;
  private String name;
  private String nationality;
  private int age;
  private List<BookResponseDTO> books;
  private Date createdAt;
  private Date updatedAt;
}
