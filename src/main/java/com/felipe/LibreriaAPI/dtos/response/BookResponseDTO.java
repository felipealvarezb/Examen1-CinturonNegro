package com.felipe.LibreriaAPI.dtos.response;

import com.felipe.LibreriaAPI.dtos.AuthorDTO;
import com.felipe.LibreriaAPI.dtos.EditorialDTO;
import com.felipe.LibreriaAPI.entities.Author;
import com.felipe.LibreriaAPI.entities.Editorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

  private Long bookId;
  private String title;
  private String description;
  private Author author;
  private Editorial editorial;
  private String gender;
  private Date createdAt;
  private Date updatedAt;
}
