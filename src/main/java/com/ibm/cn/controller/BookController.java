package com.ibm.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cn.model.Book;
import com.ibm.cn.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	// @GetMapping("/addBook")
	@PostMapping("/addBook")
	public void addBook(@RequestBody Book b) {

//		Book b = new Book();
//		b.setName("西厢记");
//		b.setAuthor("魯迅");
		int i = bookService.addBook(b);
		System.out.println("addBook>>" + i);
	}

	@PostMapping("/updateBook")
	public void updateBook(@RequestBody Book b) {
		int i = bookService.updateBookById(b);
		System.out.println("id" + b.getId());
	}

	// 查询
	@GetMapping("/findAll")
	public List<Book> findBook() {
		List<Book> bl = bookService.getAllBooks();
		System.out.println(bl);
		return bl;
	}

	// 分页查询
	@ResponseBody
	@RequestMapping("/book/{currPage}/{pageSize}")
	public List<Book> queryBooksBySql(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize) {
		List<Book> books = bookService.queryBooksBySql(currPage, pageSize);
		return books;
	}
}
