package dao;

import data.Books;
import exception.PersistException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by HappyQ on 12.06.2015.
 */
public abstract class BooksDaoImp<Books> implements BooksDao<Books> {
    private static final Logger logger = Logger.getLogger(BooksDaoImp.class);

    private SessionFactory sessionFactory;
    private final ThreadLocal sessions = new ThreadLocal();
    protected Session session;
    private HibernateUtil util;

    @Override
    public Session getSession() {
        Session session = (Session) sessions.get();
        if (session == null || !(session.isOpen())) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

//    public void clearSession(ThreadLocal sessionStatus) {
//        boolean cleaner = (boolean) sessionStatus.get();
//        if (true == cleaner) {
//            if ((session != null) && (session.isOpen())) {
//                session.clear();
//            }
//            sessionStatus.set(false);
//        }
//    }

    @Override
    public void save(Books books) throws PersistException {
        try {
            session = getSession();
            session.save(books);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new PersistException(e);
        }
    }


    public List<Books> getAll() throws PersistException {
        List<Books> list;
        try {
            session = getSession();
            list = parseResultSet(session);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new PersistException(e);
        }
        return list;
    }

    protected abstract List<Books> parseResultSet(Session session) throws PersistException;


}
