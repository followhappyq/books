package by.academy.aop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Book;
import beans.BookReader;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger logger = Logger.getLogger(App.class);
	public static void main(String[] args) throws NullPointerException{
		/*ApplicationContext context = new ClassPathXmlApplicationContext("books.xml");
		BookReader reader = (BookReader)context.getBean("BookReader", BookReader.class);
		List<Book> books = reader.readBooks("test");
		for (Book book: books){
			System.out.println(book);
		}*/
		try{
			String fileNames = "E:\\books-reader\\src\\\\main\\resources\\books.xml";
			Path path = Paths.get(fileNames);
			Scanner scanner = new Scanner(path);
			scanner.useDelimiter(",");
			String name;
			String author;
			String year;
			while (scanner.hasNextLine()){
				for(int i=0;i<3;i++){
					
				}
			}


		}catch (){

		} catch (IOException e) {
			logger.error("e.printStackTrace()");
		}


	}


}
