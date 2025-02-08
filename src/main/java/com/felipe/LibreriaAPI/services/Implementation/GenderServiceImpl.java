package com.felipe.LibreriaAPI.services.Implementation;

import com.felipe.LibreriaAPI.entities.Gender;
import com.felipe.LibreriaAPI.repositories.GenderRepository;
import com.felipe.LibreriaAPI.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService {

  @Autowired
  GenderRepository genderRepository;

  @Override
  public Gender createGender(Gender gender) {
    Gender savedGender = genderRepository.save(gender);
    return savedGender;
  }

  @Override
  public Gender updateGender(Long id, Gender gender) {
    Gender existingGender = genderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Gender not found"));

    existingGender.setName(gender.getName());

    Gender updatedGender = genderRepository.save(existingGender);
    return updatedGender;
  }

  @Override
  public void deleteGender(Long id) {
    Gender existingGender = genderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Gender not found"));

    genderRepository.delete(existingGender);
  }
}
