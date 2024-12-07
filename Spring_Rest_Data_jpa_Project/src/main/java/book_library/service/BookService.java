package book_library.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book_library.entity.Book;
import book_library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bRepositoryReference;
	
	public Collection<Book>getAllBooks(){
		Collection<Book>allBooks=bRepositoryReference.findAll();
		return allBooks;
		
	}
	public Book getOneBook(int bookId) {
		Book foundBook=null;
		Optional<Book>opt=bRepositoryReference.findById(bookId);
		if(opt.isPresent()) 
			foundBook=opt.get();
		return foundBook;
	}
public void createNewBook(Book newBook) {
		bRepositoryReference.save(newBook);
	}
public void upadteExisitingBook(Book exixstingBook) {
	bRepositoryReference.save(exixstingBook);
}
public void deleteOneBook(int bookId) {
	bRepositoryReference.deleteById(bookId);
}
}
