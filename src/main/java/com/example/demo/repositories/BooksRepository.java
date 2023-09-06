package com.example.demo.repositories;

import com.example.demo.entities.Books;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {



}
