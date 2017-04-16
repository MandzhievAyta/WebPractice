package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final String PERSISTENT_UNIT_NAME = "jpa";

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
    }

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }

    public static void closeEMF() {
        emf.close();
    }
}
