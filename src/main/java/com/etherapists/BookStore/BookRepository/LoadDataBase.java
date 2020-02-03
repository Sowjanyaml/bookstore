package com.etherapists.BookStore.BookRepository;

import java.time.ZonedDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etherapists.BookStore.BookEntity.Book;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDataBase {

	@Bean
	CommandLineRunner initDatabase(BookRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Book("To Kill a Mockingbird","Harper Lee", 2344324,"Gothic", ZonedDateTime.now(), ZonedDateTime.now())));
			
			log.info("Preloading " + repository.save(new Book("1984","George Orwell.", 97804515,"Fiction",ZonedDateTime.now(), ZonedDateTime.now())));
			
			log.info("Preloading " + repository.save(new Book("Catch22","Heller", 45345,"DarkComedy",ZonedDateTime.now(), ZonedDateTime.now())));
			
		};
	}
}
