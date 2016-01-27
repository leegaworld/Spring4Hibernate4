package org.spring4.sample.dao.common;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T getByKey(PK key) {

        return (T) getSession().get(persistentClass, key);
    }

    public void persist(T entity) {

        getSession().persist(entity);
    }

    public void delete(T entity) {

        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);
    }

}
