package org.itstep.myWebApp.service;

import org.itstep.myWebApp.UserTestData;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.util.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration({"classpath:spring/spring.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/initDB.sql")
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void getAll() throws Exception {
        List<User> users = service.getAll();
        Assert.assertEquals(4, users.size());
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
        Assert.assertEquals(3, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(0);
    }

    @Test
    public void save() throws Exception {
        User user = service.save(UserTestData.USER);
        Assert.assertEquals(user, service.getById(5));
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() throws Exception {
        service.update(service.getById(0));
    }

    @Test
    public void getById() throws Exception {
        Assert.assertNotNull(service.getById(1));
    }

}