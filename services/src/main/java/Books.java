import data.util.StatusEnum;

import java.util.List;

/**
 * Created by HappyQ on 12.06.2015.
 */
public interface Books {
    List<Books> getAllBooks();
    Books saveBooks(Books books);



}
