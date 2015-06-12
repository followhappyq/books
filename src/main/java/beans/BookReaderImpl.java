package beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("BookReader")
public class BookReaderImpl implements BookReader {

	public List<Book> readBooks(String fileName) {
		Book book = new Book();
		book.setName("Book1");
		book.setAuthor("Ivan Spresov");
		book.setYear("2015");
	
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		return books;
	}

}
