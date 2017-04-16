package DAO;

import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


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
        List<T> res;
        EntityManager manager = HibernateUtil.getEm();
        res = manager.createQuery("select e from " + type.getSimpleName() + " e", type).getResultList();
        manager.close();
        return res;

    }
    public void add(T entity) {
        EntityManager manager = HibernateUtil.getEm();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
    }
    public void deleteById(int id) {
        T delCandidate;
        EntityManager manager = HibernateUtil.getEm();
        manager.getTransaction().begin();
        delCandidate = manager.find(type, id);
        manager.remove(delCandidate);
        manager.getTransaction().commit();
        manager.close();
    }
    public void update(T entity) {
        EntityManager manager = HibernateUtil.getEm();
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
        manager.close();
    }
    public T getById(Integer id) {
        T entity;
        EntityManager manager = HibernateUtil.getEm();
        entity = manager.find(type, id);
        manager.close();
        return entity;
    }

}
