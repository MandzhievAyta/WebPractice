package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.ClientsDAO;
import models.Clients;

@Service
public class ClientsService {

    private ClientsDAO ClientsDAO;

    public void setClientsDAO(ClientsDAO ClientsDAO) {
        this.ClientsDAO = ClientsDAO;
    }

    @Transactional
    public void addClients(Clients p) {
        this.ClientsDAO.addSample(p);
    }

    @Transactional
    public void updateClients(Clients p) {
        this.ClientsDAO.updateSample(p);
    }

    @Transactional
    public List<Clients> listClients() {
        return this.ClientsDAO.listAll();
    }

    @Transactional
    public Clients getClientsById(Integer id) {
        return this.ClientsDAO.getById(id);
    }

    @Transactional
    public void removeClients(Integer id) {
        this.ClientsDAO.removeById(id);
    }

}
