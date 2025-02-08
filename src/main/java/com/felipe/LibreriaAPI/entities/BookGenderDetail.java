package com.felipe.LibreriaAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookGenderDetail {

  @Id
  @Column(name = "id_book_gender", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookGenderId;

  @ManyToOne
  @JoinColumn(name = "id_book", nullable = false)
  private Book book;

  @ManyToOne
  @JoinColumn(name = "id_gender", nullable = false)
  private Gender gender;

  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @UpdateTimestamp
  private Date updatedAt;
}
