package com.etherapists.BookStore.BookController;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.etherapists.BookStore.BookEntity.Book;
import com.etherapists.BookStore.BookException.BookNotFoundException;
import com.etherapists.BookStore.BookRepository.BookRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookRepository mockRepository;

	@Before
	public void init() {
		Book book = new Book("To Kill a Mockingbird", "Harper Lee", 2344324, "Gothic", ZonedDateTime.now(),
				ZonedDateTime.now());
		when(mockRepository.findById(1L)).thenReturn(Optional.of(book));
	}

	@Test
	@WithMockUser("USER")
	public void givenBook_whenFindBook_thenReturnBook() throws Exception {

		mockMvc.perform(get("/books/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("To Kill a Mockingbird")))
				.andExpect(jsonPath("$.author", is("Harper Lee")));
	}
	

	@Test
	@WithMockUser("USER")
	public void givenBook_whenFindNoBook_thenReturnNotFound() throws Exception {

		mockMvc.perform(get("/books/100")).andDo(print()).andExpect(status().isNotFound());
	}
}
