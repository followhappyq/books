package dao; /**
 * Created by HappyQ on 12.06.2015.
 */
import exception.PersistException;
import org.hibernate.Session;

import java.util.List;

public interface BooksDao<Books>{
        Session getSession();
        void clearSession(ThreadLocal sessionStatus);
        void save (Books books) throws PersistException;
        List<Books> getAll() throws PersistException;



}


