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
  boolean existsByBookAndGender(Book book, Gender gender);

  @Query("SELECT bgd FROM BookGenderDetail bgd WHERE bgd.book.id = :bookId AND bgd.gender.id = :genderId")
  Optional<BookGenderDetail> findByBookIdAndGenderId(Long bookId, Long genderId);
}
