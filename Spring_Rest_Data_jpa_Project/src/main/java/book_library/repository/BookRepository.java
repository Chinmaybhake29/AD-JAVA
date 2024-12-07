package book_library.repository;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book_library.entity.Book;

/*@Repository is not required because JpaRepository is already a managed component and since BookRepository 
is inherited from it, also becomes a managed component
*/
public interface BookRepository extends JpaRepository<Book, Integer>{

	
}
