package com.fdmgroup.springbootdemoJPA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;

import com.fdmgroup.springbootdemoJPA.model.Book;
import com.fdmgroup.springbootdemoJPA.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/addBook")
	public String goToaddBook(Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
	}

	@PostMapping("/processBook")
	public String processBook(Book book, Model model, HttpServletRequest req) {
		if (bookService.addBook(book)) {
			model.addAttribute("title", book.getTitle());
			return "book-created";
		}
//		return "forward:/addBook";
		// to change redirect to post request
//		req.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
		return "redirect:/addBook";
		// forward happens entirely on a server side . The web container forwards the
		// same request to the target URL
		
	}

	@PostMapping("/postaddBook")
	public String goToaddpost(Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
	}
	@GetMapping("/finByTitle/{title}")
		public String toFindBook(@PathVariable String title,Model model)
		{
		model.addAttribute("book", bookService.findBookWithTitle(title));
		return "found-book";
		
	}
	@GetMapping("/listAllBooks")
	public String goToList(Model model)
	{
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "list-book";
	}
}
