package DAO.Impl;

import DAO.AbstractDAO;
import models.Accounts;
import models.ContractsHistory;
import models.WriteoffsHistory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ayta on 16.04.17.
 */
@Repository
public class WriteoffsHistoryDAO extends AbstractDAO<WriteoffsHistory> {
    public List<WriteoffsHistory> getWriteoffsHistoryByAccountId(int accountId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<WriteoffsHistory> res;
        res = session.createQuery("select e from " + type.getSimpleName() + " e where e.account.id = " + accountId).list();
        return res;
    }
}
