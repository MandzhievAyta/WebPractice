package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.ReplenishHistoryDAO;
import models.ReplenishHistory;

@Service
public class ReplenishHistoryService {

    private ReplenishHistoryDAO replenishHistoryDAO;

    public void setReplenishHistoryDAO(ReplenishHistoryDAO replenishHistoryDAO) {
        this.replenishHistoryDAO = replenishHistoryDAO;
    }

    @Transactional
    public void addReplenishHistory(ReplenishHistory p) {
        this.replenishHistoryDAO.addSample(p);
    }

    @Transactional
    public void updateReplenishHistory(ReplenishHistory p) {
        this.replenishHistoryDAO.updateSample(p);
    }

    @Transactional
    public List<ReplenishHistory> listReplenishHistory() {
        return this.replenishHistoryDAO.listAll();
    }

    @Transactional
    public ReplenishHistory getReplenishHistoryById(Integer id) {
        return this.replenishHistoryDAO.getById(id);
    }

    @Transactional
    public void removeReplenishHistory(Integer id) {
        this.replenishHistoryDAO.removeById(id);
    }

    @Transactional
    public List<ReplenishHistory> getReplenishHistoryByAccountId(int accountId) { return replenishHistoryDAO.getReplenishHistoryByAccountId(accountId); }

}
