package org.itstep.myWebApp.service;

import org.itstep.myWebApp.UserTestData;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.util.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration({"classpath:spring/spring.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/initDB.sql")
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void getAll() throws Exception {
        List<User> users = service.getAll();
        Assert.assertEquals(4, users.size());
    }

    @Test
    @DirtiesContext
    @Transactional
    public void delete() throws Exception {
        service.delete(4);
        Assert.assertEquals(4, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(0);
    }

    @Test
    @Transactional
    public void save() throws Exception {
        service.save(UserTestData.USER);
        User user = service.getById(1);
        Assert.assertEquals(UserTestData.USER, user);
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() throws Exception {
        service.update(UserTestData.USER_3);
    }

    @Test
    public void getById() throws Exception {
        User user = service.getById(1);
    }

}