package com.felipe.LibreriaAPI.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

  private String title;
  private String description;
  private Long authorId;
  private Long editorialId;
}
