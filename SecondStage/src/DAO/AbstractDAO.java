package DAO;

import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ayta on 12.04.17.
 */
public abstract class AbstractDAO<T> {
    private Class<T> type;
    public AbstractDAO() {
        Type type = getClass().getGenericSuperclass();

        while (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != AbstractDAO.class) {
            if (type instanceof ParameterizedType) {
                type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
            } else {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }

        this.type = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<T> list = session.createCriteria(type).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public void add(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }
    public void delete(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }
    public void updateFilm(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }
    public T getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        T entity = session.get(type, id);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

}
