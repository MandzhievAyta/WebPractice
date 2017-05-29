package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.SmsTariffsDAO;
import models.SmsTariffs;

@Service
public class SmsTariffsService {

    private SmsTariffsDAO smsTariffsDAO;

    public void setSmsTariffsDAO(SmsTariffsDAO smsTariffsDAO) {
        this.smsTariffsDAO = smsTariffsDAO;
    }

    @Transactional
    public void addSmsTariffs(SmsTariffs p) {
        this.smsTariffsDAO.addSample(p);
    }

    @Transactional
    public void updateSmsTariffs(SmsTariffs p) {
        this.smsTariffsDAO.updateSample(p);
    }

    @Transactional
    public List<SmsTariffs> listSmsTariffs() {
        return this.smsTariffsDAO.listAll();
    }

    @Transactional
    public SmsTariffs getSmsTariffsById(Integer id) {
        return this.smsTariffsDAO.getById(id);
    }

    @Transactional
    public void removeSmsTariffs(Integer id) {
        this.smsTariffsDAO.removeById(id);
    }

}
