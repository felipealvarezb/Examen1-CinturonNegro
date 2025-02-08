package com.felipe.LibreriaAPI.controllers;

import com.felipe.LibreriaAPI.dtos.response.BookGenderResponseDTO;
import com.felipe.LibreriaAPI.entities.BookGenderDetail;
import com.felipe.LibreriaAPI.mappers.BookGenderDetailMapper;
import com.felipe.LibreriaAPI.services.BookGenderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book-detail")
public class BookGenderDetailController {

  @Autowired
  private BookGenderDetailService bookGenderDetailService;

  @Autowired
  private BookGenderDetailMapper bookGenderDetailMapper;

  @PostMapping(value = "/book/{bookId}/gender/{genderId}")
  public ResponseEntity<BookGenderResponseDTO> assignGender(@PathVariable Long bookId, @PathVariable Long genderId) {
    BookGenderDetail bookGenderDetail = bookGenderDetailService.assignGender(bookId, genderId);
    return ResponseEntity.ok().body(bookGenderDetailMapper.bookGenderDetailToBookGenderDetailResponseDTO(bookGenderDetail));
  }

  @DeleteMapping(value = "/book/{bookId}/gender/{genderId}")
  public ResponseEntity<BookGenderResponseDTO> unassignGender(@PathVariable Long bookId, @PathVariable Long genderId) {
    BookGenderDetail bookGenderDetail = bookGenderDetailService.unassignGender(bookId, genderId);
    return ResponseEntity.ok().body(bookGenderDetailMapper.bookGenderDetailToBookGenderDetailResponseDTO(bookGenderDetail));
  }

}
