package com.iiht.spring.boot.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.iiht.spring.boot.model.Book;
import com.iiht.spring.boot.model.Subject;
import com.iiht.spring.boot.repository.BookRepository;
import com.iiht.spring.boot.repository.SubjectRepository;
import com.iiht.spring.boot.service.LibraryService;
import com.iiht.spring.boot.service.LibraryServiceImpl;

@RunWith(SpringRunner.class)
public class LibraryServiceTests {

	@TestConfiguration
	static class LibraryServiceTestContextConfiguration {

		@Bean
		public LibraryService libraryService() {
			return new LibraryServiceImpl();
		}
	}

	@Autowired
	private LibraryService libraryService;

	@MockBean
	private BookRepository bookRepository;

	@MockBean
	private SubjectRepository subjectRepository;

	@Before
	public void setUp() {
		Book book = new Book();
		book.setBookId(011l);
		book.setTitle("English");
		book.setPrice(234.50d);
		book.setVolume(01121);
		book.setPublishDate(LocalDateTime.of(2011, 02, 01, 10, 10).toLocalDate());
		List<Book> list = Arrays.asList(book);

		Mockito.when(this.bookRepository.findAll()).thenReturn(list);

		Subject subject = new Subject();
		subject.setSubjectId(01011L);
		subject.setSubtitle("Language");
		subject.setDurationInHours(130);
		List<Subject> subList = Arrays.asList(subject);
		Mockito.when(this.subjectRepository.findAll()).thenReturn(subList);
	}

	@Test
	public void testAddBook() throws ClassNotFoundException, IOException {
		Book book = new Book();
		book.setBookId(011l);
		book.setTitle("English");
		book.setPrice(234.50d);
		book.setVolume(01121);
		book.setPublishDate(LocalDateTime.of(2011, 02, 01, 10, 10).toLocalDate());
		this.libraryService.addBook(book);

	}

	@Test
	public void testSearchBook() throws ClassNotFoundException, IOException {
		Book book = new Book();
		book.setBookId(011l);
		book.setTitle("English");
		book.setPrice(234.50d);
		book.setVolume(01121);
		book.setPublishDate(LocalDateTime.of(2011, 02, 01, 10, 10).toLocalDate());

		Optional<Book> bookFound = this.libraryService.searchBook(book.getTitle());

		assertThat(bookFound.get().getTitle()).isEqualTo(book.getTitle());
	}

	@Test
	public void testDeleteBook() throws ClassNotFoundException, IOException {
		boolean status = this.libraryService.deleteBook("English");
		assertThat(status).isEqualTo(true);
	}

	@Test
	public void testAddSubject() throws ClassNotFoundException, IOException {
		Subject subject = new Subject();
		subject.setSubjectId(01011L);
		subject.setSubtitle("Language");
		subject.setDurationInHours(130);
		this.libraryService.addSubject(subject);

	}

	@Test
	public void testSearchSubject() throws ClassNotFoundException, IOException {
		Subject subject = new Subject();
		subject.setSubjectId(01011L);
		subject.setSubtitle("Language");
		subject.setDurationInHours(130);

		Optional<Subject> subjectFound = this.libraryService.searchSubject(subject.getSubtitle());

		assertThat(subjectFound.get().getSubtitle()).isEqualTo(subject.getSubtitle());
	}

	@Test
	public void testDeleteSubject() throws ClassNotFoundException, IOException {
		boolean status = this.libraryService.deleteSubject("Language");
		assertThat(status).isEqualTo(true);
	}
}
