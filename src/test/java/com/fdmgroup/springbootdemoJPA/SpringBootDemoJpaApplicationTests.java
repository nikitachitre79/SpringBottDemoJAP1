package com.fdmgroup.springbootdemoJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fdmgroup.springbootdemoJPA.service.BookService;

//@SpringBootTest
@WebMvcTest
class SpringBootDemoJpaApplicationTests {
@Autowired
	MockMvc mvc;
@MockBean
BookService bookService;
	@Test
	void contextLoads() {
	}

	@Test
	void test_get_addBook_returns_addbook_view() throws Exception
	{
		mvc.perform(MockMvcRequestBuilders.get("/addBook"))
		.andExpect(MockMvcResultMatchers.view().name("add-book"));
	}
}
