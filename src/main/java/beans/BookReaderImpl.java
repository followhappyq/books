package beans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service("BookReader")
public class BookReaderImpl implements BookReader {

	public List<Book> readBooks(String fileName) throws IOException {
		Book book = new Book();
		String fileNames = "E:\\books-reader\\src\\\\main\\resources\\books.xml";
		Path path = Paths.get(fileNames);
		Scanner scanner = new Scanner(path);
		String name;
		String author;
		String year;
		scanner.useDelimiter(",");
		while (scanner.hasNextLine()){
		//	processLine(scanner.nextLine());
		}



		List<Book> books = new ArrayList<Book>();
		books.add(book);
		return books;
	}

}
