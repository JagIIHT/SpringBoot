package com.iiht.spring.boot.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iiht.spring.boot.model.Book;
import com.iiht.spring.boot.model.Subject;

@Service
public interface LibraryService {

	Optional<Book> searchBook(String bookName) throws ClassNotFoundException, IOException;

	Optional<Subject> searchSubject(String subjectName) throws ClassNotFoundException, IOException;

	boolean deleteBook(String bookName) throws IOException, ClassNotFoundException;

	boolean deleteSubject(String subjectName) throws ClassNotFoundException, IOException;

	void addBook(Book newBook) throws IOException, ClassNotFoundException;

	void addSubject(Subject newSubject) throws IOException, ClassNotFoundException;

}
