package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.IndividualsDAO;
import models.Individuals;

@Service
public class IndividualsService {

    private IndividualsDAO individualsDAO;

    public void setIndividualsDAO(IndividualsDAO individualsDAO) {
        this.individualsDAO = individualsDAO;
    }

    @Transactional
    public void addIndividuals(Individuals p) {
        this.individualsDAO.addSample(p);
    }

    @Transactional
    public void updateIndividuals(Individuals p) {
        this.individualsDAO.updateSample(p);
    }

    @Transactional
    public List<Individuals> listIndividuals() {
        return this.individualsDAO.listAll();
    }

    @Transactional
    public Individuals getIndividualsById(Integer id) {
        return this.individualsDAO.getById(id);
    }

    @Transactional
    public void removeIndividuals(Integer id) {
        this.individualsDAO.removeById(id);
    }

}
