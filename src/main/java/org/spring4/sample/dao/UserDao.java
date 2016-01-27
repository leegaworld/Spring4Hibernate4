package org.spring4.sample.dao;

import org.spring4.sample.model.security.User;

public interface UserDao {

    public User findById(int id);

    public User findBySSO(String sso);

}
