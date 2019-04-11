package com.iiht.spring.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.spring.boot.model.Book;
import com.iiht.spring.boot.model.Subject;
import com.iiht.spring.boot.repository.BookRepository;
import com.iiht.spring.boot.repository.SubjectRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public void addSubject(Subject newSubject) {
		this.subjectRepository.save(newSubject);
	}

	private List<Subject> getSubjects() {
		return (List<Subject>) this.subjectRepository.findAll();
	}

	@Override
	public void addBook(Book newBook) {
		this.bookRepository.save(newBook);
	}

	private List<Book> getBooks() {
		return (List<Book>) this.bookRepository.findAll();
	}

	@Override
	public boolean deleteSubject(String subjectName) {
		List<Subject> subjects = getSubjects();
		Optional<Subject> opSubject = subjects.stream()
				.filter(subject -> subject.getSubtitle().equalsIgnoreCase(subjectName)).findAny();
		if (opSubject.isPresent()) {
			this.subjectRepository.deleteById(opSubject.get().getSubjectId());
		}
		return true;
	}

	@Override
	public boolean deleteBook(String bookName) {
		List<Book> books = getBooks();
		Optional<Book> opBook = books.stream().filter(book -> book.getTitle().equalsIgnoreCase(bookName)).findAny();
		if (opBook.isPresent()) {
			this.bookRepository.deleteById(opBook.get().getBookId());
		}
		return true;
	}

	@Override
	public Optional<Book> searchBook(String bookName) {
		List<Book> books = getBooks();
		return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(bookName)).findAny();
	}

	@Override
	public Optional<Subject> searchSubject(String subjectName) {
		List<Subject> subjects = getSubjects();
		return subjects.stream().filter(subject -> subject.getSubtitle().equalsIgnoreCase(subjectName)).findAny();
	}

}
