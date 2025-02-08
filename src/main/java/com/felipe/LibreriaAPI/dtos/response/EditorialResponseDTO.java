package com.felipe.LibreriaAPI.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorialResponseDTO {

  private Long editorialId;
  private String name;
  private String address;
  private Date createdAt;
  private Date updatedAt;
}
