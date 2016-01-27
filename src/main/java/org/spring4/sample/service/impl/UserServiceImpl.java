package org.spring4.sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring4.sample.dao.UserDao;
import org.spring4.sample.model.security.User;
import org.spring4.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao dao;

    public User findById(int id) {
        logger.debug(" ==> dao: " + dao);
        logger.debug(" ==> id: " + id);

        return dao.findById(id);
    }

    public User findBySso(String sso) {

        logger.debug(" ==> dao: " + dao);
        logger.debug(" ==> sso: " + sso);

        return dao.findBySSO(sso);
    }

}