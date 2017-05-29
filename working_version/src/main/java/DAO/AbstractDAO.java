package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public abstract class AbstractDAO<T> {

    protected SessionFactory sessionFactory;

    protected Class<T> type;

    public AbstractDAO() {
        Type type = getClass().getGenericSuperclass();

        // Get generic type of class at runtime
        while (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != AbstractDAO.class) {
            if (type instanceof ParameterizedType) {
                type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
            } else {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }

        this.type = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addSample(T entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    public void updateSample(T entity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(entity);
    }

    public List<T> listAll() {
        Session session = this.sessionFactory.getCurrentSession();
        System.out.println("session = " + session);
        return session.createQuery("from " + type.getSimpleName()).list();
    }

    public T getById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        return(T) session.load(this.type, id);
    }

    public void removeById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        T entity = (T) session.load(this.type, id);
        if (entity != null){
            session.delete(entity);
        }
    }
}
