package com.felipe.LibreriaAPI.services;

import com.felipe.LibreriaAPI.entities.BookGenderDetail;

public interface BookGenderDetailService {

  BookGenderDetail assignGender(Long bookId, Long genderId);

  BookGenderDetail unassignGender(Long bookId, Long genderId);
}
