package com.newbietop.book.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newbietop.book.domain.Book;
import com.newbietop.book.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //생성자를 자동으로 만들어줌test
@RestController
public class BookController {

	private final BookService bookService;
	
	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book){
		return new ResponseEntity<>(bookService.저장하기(book),HttpStatus.CREATED);
	}
	
	@GetMapping("/book")
	public ResponseEntity<?> fidAll(){
		return new ResponseEntity<>(bookService.모두가져오기(),HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return new ResponseEntity<>(bookService.한건가져오기(id),HttpStatus.OK);
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Book book){
		return new ResponseEntity<>(bookService.수정하기(id,book),HttpStatus.OK);
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity<>(bookService.삭제하기(id),HttpStatus.OK);
	}
}
