package service;

import dao.AccountDAO;
import dao.hibernateImpl.AccountDAOHibernateImpl;
import model.Account;

import java.util.List;

public class AccountService {
    private AccountDAO accountDAO = new AccountDAOHibernateImpl();

    public AccountService() {
    }

    public Account findAccount(Long id) {
        return accountDAO.getByID(id);
    }

    public void setAccount(Account account) {
        accountDAO.save(account);
    }

    public void updateAccount(Account account) {
        accountDAO.update(account);
    }

    public void deleteAccount(Account account) {
        accountDAO.delete(account);
    }

    public List<Account> getAllAccounts() {
        return accountDAO.getAll();
    }
}
