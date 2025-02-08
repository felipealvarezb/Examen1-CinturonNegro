package com.felipe.LibreriaAPI.services;

import com.felipe.LibreriaAPI.entities.Gender;

public interface GenderService {

  Gender createGender(Gender gender);

  Gender updateGender(Long id, Gender gender);

  void deleteGender(Long id);
}
