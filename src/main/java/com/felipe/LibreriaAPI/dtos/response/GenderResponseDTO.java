package com.felipe.LibreriaAPI.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenderResponseDTO {

  private String name;
  private Date createdAt;
  private Date updatedAt;
}
