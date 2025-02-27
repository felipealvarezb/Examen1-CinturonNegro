package com.felipe.LibreriaAPI.repositories;

import com.felipe.LibreriaAPI.entities.Book;
import com.felipe.LibreriaAPI.entities.BookGenderDetail;
import com.felipe.LibreriaAPI.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookGenderDetailRepository extends JpaRepository<BookGenderDetail, Long> {

  boolean existsByBookIdAndGenderId(Long bookId, Long genderId);

  BookGenderDetail findByBookIdAndGenderId(Long bookId, Long genderId);
}
