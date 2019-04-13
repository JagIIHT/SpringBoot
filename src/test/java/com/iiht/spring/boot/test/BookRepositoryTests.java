package com.iiht.spring.boot.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iiht.spring.boot.model.Book;
import com.iiht.spring.boot.model.Subject;
import com.iiht.spring.boot.repository.BookRepository;
import com.iiht.spring.boot.repository.SubjectRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	private Book book;
	private Subject subject;

	@Before
	public void setUp() {

		this.book = new Book();
		this.book.setBookId(0000);
		this.book.setTitle("Unit_TestCase_Book1");
		this.book.setPrice(234.50d);
		this.book.setVolume(0000);
		this.book.setPublishDate(LocalDateTime.of(2011, 02, 01, 10, 10).toLocalDate());

		this.subject = new Subject();
		this.subject.setSubjectId(00000);
		this.subject.setSubtitle("Unit_TestCase_Subject1");
		this.subject.setDurationInHours(120);
	}

	@Test
	public void testSearchBook() {
		this.bookRepository.save(this.book);
		Iterable<Book> bookFound = this.bookRepository.findAll();
		boolean[] pass = { false };
		bookFound.iterator().forEachRemaining(b -> {
			if (b.getTitle().equalsIgnoreCase(this.book.getTitle())) {
				pass[0] = true;
			}
		});
		assertTrue(pass[0]);
	}

	@Test
	public void testAddBook() {
		Book savedBook = this.bookRepository.save(this.book);
		assertThat(savedBook.getTitle()).isEqualTo(this.book.getTitle());
	}

	@Test
	public void testDeleteBook() {
		this.bookRepository.save(this.book);
		this.bookRepository.delete(this.book);
		Iterable<Book> bookFound = this.bookRepository.findAll();
		boolean[] pass = { false };
		while (bookFound.iterator().hasNext()) {
			bookFound.iterator().forEachRemaining(b -> {
				if (b.getTitle().equalsIgnoreCase(this.book.getTitle())) {
					pass[0] = true;
				}
			});
		}
		assertFalse(pass[0]);
	}

	@Test
	public void testSearchSubject() {
		this.subjectRepository.save(this.subject);
		Iterable<Subject> subjectFound = this.subjectRepository.findAll();
		boolean[] pass = { false };
		subjectFound.forEach(s -> {
			if (s.getSubtitle().equalsIgnoreCase(this.subject.getSubtitle())) {
				pass[0] = true;
			}
		});
		assertTrue(pass[0]);
	}

	@Test
	public void testAddSubject() {
		Subject subAdded = this.subjectRepository.save(this.subject);
		assertThat(subAdded.getSubtitle().equalsIgnoreCase(this.subject.getSubtitle()));
	}

	@Test
	public void testDeleteSubject() {
		this.subjectRepository.save(this.subject);
		this.subjectRepository.delete(this.subject);
		Iterable<Subject> subjectFound = this.subjectRepository.findAll();
		boolean[] pass = { false };
		subjectFound.forEach(s -> {
			if (s.getSubtitle().equalsIgnoreCase(this.subject.getSubtitle())) {
				pass[0] = true;
			}
		});
		assertFalse(pass[0]);
	}
}
