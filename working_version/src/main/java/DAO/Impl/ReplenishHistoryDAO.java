package DAO.Impl;

import DAO.AbstractDAO;
import models.Accounts;
import models.ContractsHistory;
import models.ReplenishHistory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ayta on 16.04.17.
 */
@Repository
public class ReplenishHistoryDAO extends AbstractDAO<ReplenishHistory> {
    public List<ReplenishHistory> getReplenishHistoryByAccountId(int accountId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<ReplenishHistory> res;
        res = session.createQuery("select e from " + type.getSimpleName() + " e where e.account.id = " + accountId).list();
        return res;
    }
}
