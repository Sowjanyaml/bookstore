package com.etherapists.BookStore.BookRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etherapists.BookStore.BookEntity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book findByName(String name);
}
