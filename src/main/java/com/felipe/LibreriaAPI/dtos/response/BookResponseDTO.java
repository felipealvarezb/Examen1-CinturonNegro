package com.felipe.LibreriaAPI.dtos.response;

import com.felipe.LibreriaAPI.dtos.AuthorDTO;
import com.felipe.LibreriaAPI.dtos.EditorialDTO;
import com.felipe.LibreriaAPI.dtos.GenderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

  private Long id;
  private String title;
  private String description;
  private AuthorDTO author;
  private EditorialDTO editorial;
  private List<GenderDTO> genders;
  private Date createdAt;
  private Date updatedAt;
}
