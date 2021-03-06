package util;

import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.apache.log4j.Logger;


/**
 * Created by HappyQ on 12.06.2015.
 */
public class HibernateUtil {
    private static final Logger logger = Logger.getLogger(HibernateUtil.class);

    private static HibernateUtil util = null;

    private SessionFactory sessionFactory = null;

    private HibernateUtil() {
        try {
            sessionFactory = new AnnotationConfiguration().configure().setNamingStrategy(new CustomNamingStrategy()).buildSessionFactory();
        } catch (Throwable ex) {
            logger.error(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static synchronized HibernateUtil getHibernateUtil(){
        if (util == null){
            util = new HibernateUtil();
        }
        return util;
    }
}

