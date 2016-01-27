package org.spring4.sample.service;

import org.spring4.sample.model.security.User;

public interface UserService {

    public User findById(int id);

    public User findBySso(String sso);

}
