package DAO.Impl;

import DAO.AbstractDAO;
import models.Accounts;
import models.Contacts;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ayta on 16.04.17.
 */
@Repository
public class ContactsDAO extends AbstractDAO<Contacts> {
    public List<Contacts> getContactsByClientId(int clientId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Contacts> res;
        res = session.createQuery("select e from " + type.getSimpleName() + " e where e.client.id = " + clientId).list();
        return res;
    }
}
