package service;

import java.util.List;

import DAO.Impl.ContractsHistoryDAO;
import models.ContractsHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ContractsHistoryService {

    private ContractsHistoryDAO contractsHistoryDAO;

    public void setContractsHistoryDAO(ContractsHistoryDAO contractsHistoryDAO) {
        this.contractsHistoryDAO = contractsHistoryDAO;
    }

    @Transactional
    public void addContractsHistory(ContractsHistory p) {
        this.contractsHistoryDAO.addSample(p);
    }

    @Transactional
    public void updateContractsHistory(ContractsHistory p) {
        this.contractsHistoryDAO.updateSample(p);
    }

    @Transactional
    public List<ContractsHistory> listContractsHistory() {
        return this.contractsHistoryDAO.listAll();
    }

    @Transactional
    public ContractsHistory getContractsHistoryById(Integer id) {
        return this.contractsHistoryDAO.getById(id);
    }

    @Transactional
    public void removeContractsHistory(Integer id) {
        this.contractsHistoryDAO.removeById(id);
    }
    
    @Transactional
    public List<ContractsHistory> getContractsHistoryByAccountId(Integer accountId) { return contractsHistoryDAO.getContractsHistoryByAccountId(accountId); }

}
