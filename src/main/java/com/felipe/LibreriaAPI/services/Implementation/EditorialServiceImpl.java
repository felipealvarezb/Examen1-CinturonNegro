package com.felipe.LibreriaAPI.services.Implementation;

import com.felipe.LibreriaAPI.entities.Editorial;
import com.felipe.LibreriaAPI.repositories.EditorialRepository;
import com.felipe.LibreriaAPI.services.EditorialService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl implements EditorialService {

  @Autowired
  EditorialRepository editorialRepository;

  @Override
  public Editorial createEditorial(Editorial editorial) {
    Editorial savedEditorial = editorialRepository.save(editorial);
    return savedEditorial;
  }

  @Override
  public Editorial updateEditorial(Long id, Editorial editorial) {
    Editorial existingEditorial = editorialRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Editorial not found"));

    existingEditorial.setName(editorial.getName());
    existingEditorial.setCountry(editorial.getCountry());

    Editorial updatedEditorial = editorialRepository.save(existingEditorial);
    return updatedEditorial;
  }

  @Override
  public String deleteEditorial(Long id) {
    Editorial existingEditorial = editorialRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Editorial not found"));

    editorialRepository.delete(existingEditorial);

    return "Editorial deleted successfully";
  }
}
