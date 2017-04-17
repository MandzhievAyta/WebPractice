package DAO.Impl;

import DAO.AbstractDAO;
import models.Accounts;
import models.WriteoffsHistory;
import org.hibernate.Hibernate;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by ayta on 16.04.17.
 */
public class WriteoffsHistoryDAO extends AbstractDAO<WriteoffsHistory> {
    public List<WriteoffsHistory> getWriteoffsByAccountId(int accountId) {
        List<WriteoffsHistory> res;
        Accounts cur_acc;
        EntityManager em = HibernateUtil.getEm();
        cur_acc = em.createQuery("select e from " + Accounts.class.getSimpleName() +
                " e where e.id = " + accountId, Accounts.class)
                .getSingleResult();
        Hibernate.initialize(cur_acc.getWriteoffsHistories());
        res = (List<WriteoffsHistory>)cur_acc.getWriteoffsHistories();
        em.close();
        return res;
    }
}
