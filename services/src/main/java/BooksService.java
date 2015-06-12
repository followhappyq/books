import java.util.List;

import dao.BooksDaoImp;
import daofactory.DaoFactoryImpl;
import daofactory.IDaoFactory;
import data.util.StatusEnum;
import data.CustomEntity;
import exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by HappyQ on 12.06.2015.
 */
public class BooksService implements Books {
    private static final Logger logger = Logger.getLogger(BooksService.class);

    private static BooksService BooksServiceInst;
    private BooksDaoImp booksDaoImp;

    private final ThreadLocal sessionStatus = new ThreadLocal();
    private Session session;
    private Transaction transaction;

    @Override
    public List<Books> getAllBooks() {
        return null;
    }

    @Override
    public Books saveBooks(Books books) {

        Long savedPageId = null;
        try {
            session = booksDaoImp.getSession();
            transaction = session.beginTransaction();
            books.setStatus(StatusEnum.SAVED);
            booksDaoImp.save(books);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Error get list of Categories from database" + e);
            transaction.rollback();
        } catch (PersistException e) {
            logger.error(e);
        }finally {
            sessionStatus.set(true);
            booksDaoImp.clearSession(sessionStatus);
        }
        return books;
    }
}
