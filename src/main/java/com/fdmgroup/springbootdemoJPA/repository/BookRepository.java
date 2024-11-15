package com.fdmgroup.springbootdemoJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.springbootdemoJPA.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	public boolean existsBytitleAndAuthor(String title,String author);
	
	@Query("select b from Book b where upper(b.title) like concat('%',upper(:title),'%')")
	List<Book> findByTitle(@Param("title") String title);
}
