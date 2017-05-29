package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.WriteoffsHistoryDAO;
import models.WriteoffsHistory;

@Service
public class WriteoffsHistoryService {

    private WriteoffsHistoryDAO writeoffsHistoryDAO;

    public void setWriteoffsHistoryDAO(WriteoffsHistoryDAO writeoffsHistoryDAO) {
        this.writeoffsHistoryDAO = writeoffsHistoryDAO;
    }

    @Transactional
    public void addWriteoffsHistory(WriteoffsHistory p) {
        this.writeoffsHistoryDAO.addSample(p);
    }

    @Transactional
    public void updateWriteoffsHistory(WriteoffsHistory p) {
        this.writeoffsHistoryDAO.updateSample(p);
    }

    @Transactional
    public List<WriteoffsHistory> listWriteoffsHistory() {
        return this.writeoffsHistoryDAO.listAll();
    }

    @Transactional
    public WriteoffsHistory getWriteoffsHistoryById(Integer id) {
        return this.writeoffsHistoryDAO.getById(id);
    }

    @Transactional
    public void removeWriteoffsHistory(Integer id) {
        this.writeoffsHistoryDAO.removeById(id);
    }

    @Transactional
    public List<WriteoffsHistory> getWriteoffsHistoryByAccountId(int accountId) { return writeoffsHistoryDAO.getWriteoffsHistoryByAccountId(accountId); }
}
