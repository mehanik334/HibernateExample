package dao.hibernateImpl;

import dao.AccountDAO;
import model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AccountDAOHibernateImpl implements AccountDAO {


    @Override
    public Account getByID(Long aLong) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Account.class, aLong);
    }

    @Override
    public void save(Account obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Account obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Account obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }



    @Override
    public List<Account> getAll() {
        return (List<Account>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM model.Account").list();
    }
}
