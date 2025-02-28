package com.felipe.LibreriaAPI.services;

import com.felipe.LibreriaAPI.entities.Editorial;

public interface EditorialService {

  Editorial createEditorial(Editorial editorial);

  Editorial updateEditorial(Long id, Editorial editorial);

  String deleteEditorial(Long id);
}
