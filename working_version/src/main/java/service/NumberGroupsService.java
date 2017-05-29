package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.NumberGroupsDAO;
import models.NumberGroups;

@Service
public class NumberGroupsService {

    private NumberGroupsDAO numberGroupsDAO;

    public void setNumberGroupsDAO(NumberGroupsDAO numberGroupsDAO) {
        this.numberGroupsDAO = numberGroupsDAO;
    }

    @Transactional
    public void addNumberGroups(NumberGroups p) {
        this.numberGroupsDAO.addSample(p);
    }

    @Transactional
    public void updateNumberGroups(NumberGroups p) {
        this.numberGroupsDAO.updateSample(p);
    }

    @Transactional
    public List<NumberGroups> listNumberGroups() {
        return this.numberGroupsDAO.listAll();
    }

    @Transactional
    public NumberGroups getNumberGroupsById(Integer id) {
        return this.numberGroupsDAO.getById(id);
    }

    @Transactional
    public void removeNumberGroups(Integer id) {
        this.numberGroupsDAO.removeById(id);
    }

}
