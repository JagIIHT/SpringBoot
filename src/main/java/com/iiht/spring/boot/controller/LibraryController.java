package com.iiht.spring.boot.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iiht.spring.boot.model.Book;
import com.iiht.spring.boot.model.Subject;
import com.iiht.spring.boot.service.LibraryService;

@Controller
@RequestMapping("/springiiht")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showHome(Model model) {
		return "home";
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "book/addbook";
	}

	@RequestMapping(value = "/addsubject", method = RequestMethod.GET)
	public String addSubject(Model model) {
		model.addAttribute("subject", new Subject());
		return "subject/addsubject";
	}

	@RequestMapping(value = "/searchbook", method = RequestMethod.GET)
	public String searchBook(Model model) {
		model.addAttribute("book", new Book());
		return "book/searchbook";
	}

	@RequestMapping(value = "/searchsubject", method = RequestMethod.GET)
	public String searchSubject(Model model) {
		model.addAttribute("subject", new Subject());
		return "subject/searchsubject";
	}

	@RequestMapping(value = "/deletebook", method = RequestMethod.GET)
	public String deleteBook(Model model) {
		model.addAttribute("book", new Book());
		return "book/deletebook";
	}

	@RequestMapping(value = "/deletesubject", method = RequestMethod.GET)
	public String deleteSubject(Model model) {
		model.addAttribute("subject", new Subject());
		return "subject/deletesubject";
	}

	@RequestMapping(value = "/submitbook", method = RequestMethod.POST)
	public String submitBook(@ModelAttribute("book") Book book, Model model) {
		try {
			this.libraryService.addBook(book);
		} catch (ClassNotFoundException | IOException e) {
			return "/error";
		}
		model.addAttribute("message", "Book added successfully");
		return "/success";
	}

	@RequestMapping(value = "/submitsubject", method = RequestMethod.POST)
	public String submitSubject(@ModelAttribute("subject") Subject subject, Model model) {
		try {
			this.libraryService.addSubject(subject);
		} catch (ClassNotFoundException | IOException e) {
			return "/error";
		}
		model.addAttribute("message", "Subject added successfully");
		return "/success";
	}

	@RequestMapping(value = "bookdetail", method = RequestMethod.POST)
	public String bookDetail(@ModelAttribute("book") Book book, Model model) {
		try {
			Optional<Book> bookDetail = this.libraryService.searchBook(book.getTitle());
			if (bookDetail.isPresent()) {
				model.addAttribute(bookDetail.get());
			} else {
				model.addAttribute("message", "Book detail not found. Try with different name");
				return "/success";
			}
		} catch (ClassNotFoundException | IOException e) {
			return "/error";
		}
		return "book/bookdetail";
	}

	@RequestMapping(value = "subjectdetail", method = RequestMethod.POST)
	public String subjectDetail(@ModelAttribute("subject") Subject subject, Model model) {
		try {
			Optional<Subject> subDetail = this.libraryService.searchSubject(subject.getSubtitle());
			if (subDetail.isPresent()) {
				model.addAttribute(subDetail.get());
			} else {
				model.addAttribute("message", "Subject detail not found. Try with different name");
				return "/success";
			}
		} catch (ClassNotFoundException | IOException e) {
			return "/error";
		}
		return "subject/subjectdetail";
	}

	@RequestMapping(value = "delbook", method = RequestMethod.POST)
	public String delBookDetail(@ModelAttribute("book") Book book, Model model) {
		try {
			this.libraryService.deleteBook(book.getTitle());
		} catch (ClassNotFoundException | IOException e) {
			return "/error";
		}
		model.addAttribute("message", "Book deleted successfully");
		return "success";
	}

	@RequestMapping(value = "delsubject", method = RequestMethod.POST)
	public String delSubjectDetail(@ModelAttribute("subject") Subject subject, Model model) {
		try {
			this.libraryService.deleteSubject(subject.getSubtitle());
		} catch (ClassNotFoundException | IOException e) {
			return "/error";
		}
		model.addAttribute("message", "Subject deleted successfully");
		return "success";
	}
}
