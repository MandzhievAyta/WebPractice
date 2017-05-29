package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.InternetTariffsDAO;
import models.InternetTariffs;

@Service
public class InternetTariffsService {

    private InternetTariffsDAO internetTariffsDAO;

    public void setInternetTariffsDAO(InternetTariffsDAO internetTariffsDAO) {
        this.internetTariffsDAO = internetTariffsDAO;
    }

    @Transactional
    public void addInternetTariffs(InternetTariffs p) {
        this.internetTariffsDAO.addSample(p);
    }

    @Transactional
    public void updateInternetTariffs(InternetTariffs p) {
        this.internetTariffsDAO.updateSample(p);
    }

    @Transactional
    public List<InternetTariffs> listInternetTariffs() {
        return this.internetTariffsDAO.listAll();
    }

    @Transactional
    public InternetTariffs getInternetTariffsById(Integer id) {
        return this.internetTariffsDAO.getById(id);
    }

    @Transactional
    public void removeInternetTariffs(Integer id) {
        this.internetTariffsDAO.removeById(id);
    }

}
