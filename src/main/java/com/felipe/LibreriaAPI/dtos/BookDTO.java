package com.felipe.LibreriaAPI.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

  @NotBlank(message = "Property cannot be blank")
  @NotNull
  private String title;

  @NotBlank(message = "Property cannot be blank")
  @NotNull
  private String description;

  @NotNull
  private Long authorId;

  @NotNull
  private Long editorialId;

  @NotNull
  private List<Long> genderIds;
}
