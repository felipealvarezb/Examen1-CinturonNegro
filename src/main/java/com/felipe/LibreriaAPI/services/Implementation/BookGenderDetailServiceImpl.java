package com.felipe.LibreriaAPI.services.Implementation;

import com.felipe.LibreriaAPI.entities.Book;
import com.felipe.LibreriaAPI.entities.BookGenderDetail;
import com.felipe.LibreriaAPI.entities.Gender;
import com.felipe.LibreriaAPI.repositories.BookGenderDetailRepository;
import com.felipe.LibreriaAPI.repositories.BookRepository;
import com.felipe.LibreriaAPI.repositories.GenderRepository;
import com.felipe.LibreriaAPI.services.BookGenderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookGenderDetailServiceImpl implements BookGenderDetailService {

  @Autowired
  private BookGenderDetailRepository bookGenderDetailRepository;

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private GenderRepository genderRepository;

  @Override
  public BookGenderDetail assignGender(Long bookId, Long genderId) {
    Book existingBook = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
    Gender existingGender = genderRepository.findById(genderId).orElseThrow(() -> new RuntimeException("Gender not found"));
    boolean exists = bookGenderDetailRepository.existsByBookAndGender(existingBook, existingGender);

    if (exists) {
      throw new RuntimeException("Gender already assigned to book");
    }

    BookGenderDetail bookGenderDetail = new BookGenderDetail();
    bookGenderDetail.setBook(existingBook);
    bookGenderDetail.setGender(existingGender);
    BookGenderDetail savedBookGenderDetail = bookGenderDetailRepository.save(bookGenderDetail);
    return savedBookGenderDetail;
  }

  @Override
  public BookGenderDetail unassignGender(Long bookId, Long genderId) {
    Optional<BookGenderDetail> bookGenderDetail = bookGenderDetailRepository.findByBookIdAndGenderId(bookId, genderId);

    if (bookGenderDetail.isPresent()) {
      bookGenderDetailRepository.delete(bookGenderDetail.get());
    } else {
      throw new RuntimeException("El libro no tiene asignado este género.");
    }

    return bookGenderDetail.get();
  }
}
