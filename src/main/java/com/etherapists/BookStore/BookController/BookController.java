package com.etherapists.BookStore.BookController;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.etherapists.BookStore.BookEntity.Book;
import com.etherapists.BookStore.BookException.BookNotFoundException;
import com.etherapists.BookStore.BookRepository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/books")
	List<Book> findAll() {
		return repository.findAll();
	}

	@GetMapping("/books/{id}")
	Book findBook(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/books")
	Book addBook(@RequestBody Book newBook) {
		newBook.setCreatedDate(ZonedDateTime.now());
		newBook.setUpdatedDate(ZonedDateTime.now());
		return repository.save(newBook);
	}

	@PutMapping("/books/{id}")
	Book updateBook(@RequestBody Book book, @PathVariable Long id) {

		return repository.findById(id).map(x -> {
			x.setName(book.getName());
			x.setAuthor(book.getAuthor());
			x.setUpdatedDate(ZonedDateTime.now());
			return repository.save(x);
		}).orElseThrow(() -> new BookNotFoundException(id));
			
	}


	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
	}


}
