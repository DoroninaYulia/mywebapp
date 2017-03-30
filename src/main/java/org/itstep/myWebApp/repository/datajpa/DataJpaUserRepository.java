package org.itstep.myWebApp.repository.datajpa;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    private final static Logger logger = LoggerFactory.getLogger(DataJpaUserRepository.class);

    @Autowired
    private MyUserRepository repository;

    @Override
    public List getAll() {
        logger.info("Get all");
        return repository.findAll();
    }

    @Override
    public boolean delete(Integer id) {
        logger.info("Delete by id: {}", id);
        return repository.deleteById(id) != 0;
    }

    @Override
    public User save(User user) {
        logger.info("Save user: {}", user);
        return repository.save(user);
    }

    @Override
    public User getById(Integer id) {
        logger.info("Get by id: {}", id);
        return repository.findOne(id);
    }
}
