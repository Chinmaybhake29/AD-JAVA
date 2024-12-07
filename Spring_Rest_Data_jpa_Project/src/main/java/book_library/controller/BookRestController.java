package book_library.controller;

import java.util.Collection;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import book_library.entity.Book;
import book_library.service.BookService;

@RestController
public class BookRestController {
	@Autowired
		private BookService bookServiceReference;
	@GetMapping("/books-api")
		public Collection<Book> getAllBooks(){
			Collection<Book>allAvailableBooks=bookServiceReference.getAllBooks();
			return allAvailableBooks;
			
		}
	@GetMapping("/books-api/{book_id}")
	public Book getOneBook(@PathVariable("book_id") int bookid) {
		Book foundBook=bookServiceReference.getOneBook(bookid);
		//If book is not found raise BookNotfound exception
		
		if(foundBook==null)
			throw new RuntimeErrorException(null, "Book with given Id not found");
		return foundBook;
	}
	@PostMapping("/books-api")
    public void createNewBook(@RequestBody Book newBook) {
		System.out.println("ReciveBook"+newBook);
    		bookServiceReference.createNewBook(newBook);
	}
	@PutMapping("/books-api")
	public void updateExistingB(@RequestBody Book existingBook) {
		bookServiceReference.upadteExisitingBook(existingBook);
	}
	@DeleteMapping("/books-api/{bookId}")
	public void deleteOneBook(@PathVariable int bookId) {
		bookServiceReference.deleteOneBook(bookId);
	}
	
		
}
