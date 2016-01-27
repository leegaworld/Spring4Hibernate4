package org.spring4.sample.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.spring4.sample.dao.UserDao;
import org.spring4.sample.dao.common.AbstractDao;
import org.spring4.sample.model.security.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User findById(int id) {
        return getByKey(id);
    }

    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }


}
