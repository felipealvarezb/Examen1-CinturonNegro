package com.felipe.LibreriaAPI.repositories;

import com.felipe.LibreriaAPI.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
}
