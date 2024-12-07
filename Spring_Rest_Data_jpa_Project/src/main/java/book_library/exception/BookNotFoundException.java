package book_library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{
		private int invalidId;
		
		public BookNotFoundException(String errorMessage, int invalidId) {
			super(errorMessage);
			this.invalidId=invalidId;
		}
		@Override
		public String getMessage() {
			String message=super.getMessage();
			String finalmessage=message+"===>"+invalidId;
			return finalmessage;
		}
}
