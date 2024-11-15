package com.fdmgroup.springbootdemoJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.springbootdemoJPA.model.Book;
import com.fdmgroup.springbootdemoJPA.repository.BookRepository;

@Service
public class BookService {
private BookRepository bookRepo;
@Autowired
public BookService(BookRepository bookRepo) {
	super();
	this.bookRepo = bookRepo;
}

public boolean addBook(Book book)
{
	if(!bookRepo.existsBytitleAndAuthor(book.getTitle()	, book.getAuthor()))
	{
		bookRepo.save(book);
		return true;
	}
	return false;
}

public List<Book> findBookWithTitle(String title)
{
	return bookRepo.findByTitle(title);
}

public List<Book> findAll() {
	// TODO Auto-generated method stub
	return bookRepo.findAll();
}
}
