package org.itstep.myWebApp.repository;

import org.itstep.myWebApp.model.User;

import java.util.List;

public interface UserRepository {

    List getAll();

    boolean delete(Integer id);

    User save(User user);

    User getById(Integer id);

}
