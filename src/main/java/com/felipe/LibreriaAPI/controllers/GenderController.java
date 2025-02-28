package com.felipe.LibreriaAPI.controllers;

import com.felipe.LibreriaAPI.dtos.GenderDTO;
import com.felipe.LibreriaAPI.dtos.response.GenderResponseDTO;
import com.felipe.LibreriaAPI.entities.Gender;
import com.felipe.LibreriaAPI.mappers.GenderMapper;
import com.felipe.LibreriaAPI.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gender")
public class GenderController {

  @Autowired
  private GenderService genderService;

  @Autowired
  private GenderMapper genderMapper;

  @PostMapping
  public ResponseEntity<GenderResponseDTO> createGender(@Validated @RequestBody GenderDTO genderDTO) {
    Gender gender = genderMapper.genderDtoToGender(genderDTO);

    Gender createdGender = genderService.createGender(gender);

    return ResponseEntity.ok().body(genderMapper.genderToGenderResponseDTO(createdGender));
  }

  @PutMapping(value = "/{genderId}")
  public ResponseEntity<GenderResponseDTO> updateGender(@PathVariable Long genderId, @Validated @RequestBody GenderDTO genderDTO) {
    Gender gender = genderMapper.genderDtoToGender(genderDTO);

    Gender updatedGender = genderService.updateGender(genderId, gender);

    return ResponseEntity.ok().body(genderMapper.genderToGenderResponseDTO(updatedGender));
  }

  @DeleteMapping(value = "/{genderId}")
  public ResponseEntity<String> deleteGender(@PathVariable Long genderId) {
    String message = genderService.deleteGender(genderId);
    return ResponseEntity.ok().body(message);
  }
}
