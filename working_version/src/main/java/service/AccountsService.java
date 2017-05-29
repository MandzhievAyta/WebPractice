package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Impl.AccountsDAO;
import models.Accounts;

@Service
public class AccountsService {

    private AccountsDAO accountsDAO;

    public void setAccountsDAO(AccountsDAO accountsDAO) {
        this.accountsDAO = accountsDAO;
    }

    @Transactional
    public void addAccounts(Accounts p) {
        this.accountsDAO.addSample(p);
    }

    @Transactional
    public void updateAccounts(Accounts p) {
        this.accountsDAO.updateSample(p);
    }

    @Transactional
    public List<Accounts> listAccounts() {
        return this.accountsDAO.listAll();
    }

    @Transactional
    public Accounts getAccountsById(Integer id) {
        return this.accountsDAO.getById(id);
    }

    @Transactional
    public void removeAccounts(Integer id) {
        this.accountsDAO.removeById(id);
    }

    @Transactional
    public List<Accounts> getAccountsByClientId(Integer client_id) { return accountsDAO.getAccountsByClientId(client_id); }
}
