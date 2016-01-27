package org.spring4.sample.dao.impl;

import org.spring4.sample.dao.MyEmpDao;
import org.spring4.sample.dao.common.AbstractDao;
import org.spring4.sample.model.MyEmp;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MyEmpDaoImpl extends AbstractDao<Integer, MyEmp> implements MyEmpDao {

    /*public MyEmpDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    @Transactional
    public List<MyEmp> list() {

        List<MyEmp> list = (List<MyEmp>)createEntityCriteria().list();

        return list;
    }
}
