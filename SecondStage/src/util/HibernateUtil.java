package util;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by ayta on 28.03.17.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Accounts.class);
        configuration.addAnnotatedClass(CallTariffs.class);
        configuration.addAnnotatedClass(Clients.class);
        configuration.addAnnotatedClass(Contacts.class);
        configuration.addAnnotatedClass(ContractsHistory.class);
        configuration.addAnnotatedClass(Individuals.class);
        configuration.addAnnotatedClass(InternetTariffs.class);
        configuration.addAnnotatedClass(NumberGroups.class);
        configuration.addAnnotatedClass(Organizations.class);
        configuration.addAnnotatedClass(ReplenishHistory.class);
        configuration.addAnnotatedClass(SmsTariffs.class);
        configuration.addAnnotatedClass(WriteoffsHistory.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
