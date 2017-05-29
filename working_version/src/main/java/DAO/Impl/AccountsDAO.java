package DAO.Impl;

import DAO.AbstractDAO;
import models.Accounts;
import models.ContractsHistory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ayta on 16.04.17.
 */
@Repository
public class AccountsDAO extends AbstractDAO<Accounts> {
    public List<Accounts> getAccountsByClientId(int clientId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Accounts> res;
        res = session.createQuery("select e from " + type.getSimpleName() + " e where e.client.id = " + clientId).list();
        return res;
    }
}
