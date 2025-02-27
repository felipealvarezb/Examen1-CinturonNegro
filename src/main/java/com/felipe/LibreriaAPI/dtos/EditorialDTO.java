package com.felipe.LibreriaAPI.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorialDTO {

  @NotBlank(message = "Property cannot be blank")
  @NotNull
  private String name;

  @NotBlank(message = "Property cannot be blank")
  @NotNull
  private String country;
}
