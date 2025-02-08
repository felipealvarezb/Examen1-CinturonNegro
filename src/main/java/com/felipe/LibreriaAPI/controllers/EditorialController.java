package com.felipe.LibreriaAPI.controllers;

import com.felipe.LibreriaAPI.dtos.EditorialDTO;
import com.felipe.LibreriaAPI.dtos.response.EditorialResponseDTO;
import com.felipe.LibreriaAPI.entities.Editorial;
import com.felipe.LibreriaAPI.mappers.EditorialMapper;
import com.felipe.LibreriaAPI.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/editorial")
public class EditorialController {

  @Autowired
  EditorialService editorialService;

  @Autowired
  EditorialMapper editorialMapper;

  @PostMapping
  public ResponseEntity<EditorialResponseDTO> createEditorial(@Validated @RequestBody EditorialDTO editorialDTO) {
    Editorial editorial = editorialMapper.editorialDTOToEditorial(editorialDTO);

    Editorial createdEditorial = editorialService.createEditorial(editorial);

    return ResponseEntity.ok(editorialMapper.editorialToEditorialResponseDTO(createdEditorial));
  }

  @PutMapping(value = "/{editorialId}")
  public ResponseEntity<EditorialResponseDTO> updateEditorial(@PathVariable Long editorialId, @Validated @RequestBody EditorialDTO editorialDTO) {
    Editorial editorial = editorialMapper.editorialDTOToEditorial(editorialDTO);

    Editorial updatedEditorial = editorialService.updateEditorial(editorialId, editorial);

    return ResponseEntity.ok(editorialMapper.editorialToEditorialResponseDTO(updatedEditorial));
  }

  @DeleteMapping(value = "/{editorialId}")
  public ResponseEntity<Void> deleteEditorial(@PathVariable Long editorialId) {
    editorialService.deleteEditorial(editorialId);
    return ResponseEntity.ok().build();
  }
}
