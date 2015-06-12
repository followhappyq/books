package by.academy.aop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Book;
import beans.BookReader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("books.xml");
		BookReader reader = (BookReader)context.getBean("BookReader", BookReader.class);
		List<Book> books = reader.readBooks("test");
		for (Book book: books){
			System.out.println(book);
		}

	}
}
