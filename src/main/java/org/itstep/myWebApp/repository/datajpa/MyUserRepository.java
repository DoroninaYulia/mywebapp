package org.itstep.myWebApp.repository.datajpa;

import org.itstep.myWebApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MyUserRepository extends JpaRepository<User, Integer> {

    @Override
    List<User> findAll();

    /*@Query("delete from User u where u.id=:id")*/
    @Transactional
    int deleteById(/*@Param("id")*/ Integer id);

    User getByEmail(String email);

    @Override
    @Transactional
    User save(User user);

    @Override
    User findOne(Integer integer);
}
