package com.felipe.LibreriaAPI.repositories;

import com.felipe.LibreriaAPI.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
}
