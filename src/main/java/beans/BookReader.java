package beans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookReader {
	List<Book> readBooks(String fileName) throws IOException;

}
