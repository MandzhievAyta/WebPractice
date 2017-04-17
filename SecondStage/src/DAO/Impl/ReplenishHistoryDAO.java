package DAO.Impl;

import DAO.AbstractDAO;
import models.Accounts;
import models.ReplenishHistory;
import org.hibernate.Hibernate;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by ayta on 16.04.17.
 */
public class ReplenishHistoryDAO extends AbstractDAO<ReplenishHistory> {
    public List<ReplenishHistory> getReplenishByAccountId(int accountId) {
        List<ReplenishHistory> res;
        Accounts cur_acc;
        EntityManager em = HibernateUtil.getEm();
        cur_acc = em.createQuery("select e from " + Accounts.class.getSimpleName() +
                " e where e.id = " + accountId, Accounts.class)
                .getSingleResult();
        Hibernate.initialize(cur_acc.getReplenishHistories());
        res = (List<ReplenishHistory>)cur_acc.getReplenishHistories();
        em.close();
        return res;
    }
}
