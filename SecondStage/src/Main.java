
import DAO.AbstractDAO;
import models.Contacts;
import util.HibernateUtil;

import java.util.List;


/**
 * Created by ayta on 27.03.17.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        AbstractDAO<Contacts> contactsDAO = new AbstractDAO<Contacts>() {};
        List<Contacts> contactsList = contactsDAO.getAll();
        for (Contacts c : contactsList) {
            System.out.println(c);
        }
        HibernateUtil.closeSessionFactory();
        System.out.println("!!!");

    }
}