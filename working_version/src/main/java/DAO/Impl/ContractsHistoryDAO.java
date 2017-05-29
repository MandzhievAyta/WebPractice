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
public class ContractsHistoryDAO extends AbstractDAO<ContractsHistory> {
    public List<ContractsHistory> getContractsHistoryByAccountId(int accountId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<ContractsHistory> res;
        res = session.createQuery("select e from " + type.getSimpleName() + " e where e.account.id = " + accountId).list();
        return res;
    }
}
