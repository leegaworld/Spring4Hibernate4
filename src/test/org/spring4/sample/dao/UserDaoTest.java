package org.spring4.sample.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations={"classpath*:/WEB-INF/servlet-context.xml"})
@Transactional
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testList() {
       /* List<User> list = userDao.list();
        assertNotNull(list);*/

       /* boolean flag = list.size() > 0 ? true : false;
        assertTrue(flag);*/
    }
}
