package DAO.Impl;

import DAO.AbstractDAO;
import models.Accounts;
import models.Contacts;
import models.ContractsHistory;
import org.hibernate.Hibernate;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by ayta on 16.04.17.
 */
public class ContractsHistoryDAO extends AbstractDAO<ContractsHistory> {
    public List<ContractsHistory> getContractsByAccountId(int accountId) {
        List<ContractsHistory> res;
        Accounts cur_acc;
        EntityManager em = HibernateUtil.getEm();
        cur_acc = em.createQuery("select e from " + Accounts.class.getSimpleName() +
                        " e where e.id = " + accountId, Accounts.class)
                .getSingleResult();
        Hibernate.initialize(cur_acc.getContractsHistories());
        res = (List<ContractsHistory>)cur_acc.getContractsHistories();
        em.close();
        return res;
    }
}
