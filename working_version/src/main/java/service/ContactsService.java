package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.ContactsDAO;
import models.Contacts;

@Service
public class ContactsService {

    private ContactsDAO contactsDAO;

    public void setContactsDAO(ContactsDAO contactsDAO) {
        this.contactsDAO = contactsDAO;
    }

    @Transactional
    public void addContacts(Contacts p) {
        this.contactsDAO.addSample(p);
    }

    @Transactional
    public void updateContacts(Contacts p) {
        this.contactsDAO.updateSample(p);
    }

    @Transactional
    public List<Contacts> listContacts() {
        return this.contactsDAO.listAll();
    }

    @Transactional
    public Contacts getContactsById(Integer id) {
        return this.contactsDAO.getById(id);
    }

    @Transactional
    public void removeContacts(Integer id) {
        this.contactsDAO.removeById(id);
    }

    @Transactional
    public List<Contacts> getContactsByClientId(Integer client_id) { return contactsDAO.getContactsByClientId(client_id); }
}
