package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.OrganizationsDAO;
import models.Organizations;

@Service
public class OrganizationsService {

    private OrganizationsDAO organizationsDAO;

    public void setOrganizationsDAO(OrganizationsDAO organizationsDAO) {
        this.organizationsDAO = organizationsDAO;
    }

    @Transactional
    public void addOrganizations(Organizations p) {
        this.organizationsDAO.addSample(p);
    }

    @Transactional
    public void updateOrganizations(Organizations p) {
        this.organizationsDAO.updateSample(p);
    }

    @Transactional
    public List<Organizations> listOrganizations() {
        return this.organizationsDAO.listAll();
    }

    @Transactional
    public Organizations getOrganizationsById(Integer id) {
        return this.organizationsDAO.getById(id);
    }

    @Transactional
    public void removeOrganizations(Integer id) {
        this.organizationsDAO.removeById(id);
    }

}
