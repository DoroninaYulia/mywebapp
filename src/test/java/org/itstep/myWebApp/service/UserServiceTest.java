package org.itstep.myWebApp.service;

import org.itstep.myWebApp.UserTestData;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.util.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class UserServiceTest {

    @Autowired
    protected UserService service;

    @Test
    public void getAll() throws Exception {
        List<User> users = service.getAll();
        Assert.assertEquals(2, users.size());
        Assert.assertArrayEquals(new User[]{UserTestData.USER_1, UserTestData.USER_2}, users.toArray());
    }

    @Test
    @DirtiesContext
    public void delete() throws Exception {
        service.delete(1);
        Assert.assertEquals(1, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(0);
    }

    @Test
    @DirtiesContext
    public void save() throws Exception {
        User user = new User("111", "111", "111", "111@asd.com");
        User save = service.save(user);
        user.setId(3);
        Assert.assertEquals(user, save);
        Assert.assertEquals(3, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() throws Exception {
        service.update(UserTestData.USER_3);
    }

    @Test
    public void getById() throws Exception {
        User user = service.getById(1);
        Assert.assertEquals(UserTestData.USER_1, user);
    }

}