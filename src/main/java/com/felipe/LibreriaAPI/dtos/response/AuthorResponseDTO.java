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
  private Long id;
  private String name;
  private String nationality;
  private int age;
  private Date createdAt;
  private Date updatedAt;
}
