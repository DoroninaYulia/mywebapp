package org.itstep.myWebApp.repository.jpa;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> getAll() {
        TypedQuery<User> namedQuery = manager.createNamedQuery(User.GET_ALL, User.class);
        return namedQuery.getResultList();
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        Query query = manager.createQuery("DELETE FROM User u WHERE u.id=:id");
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    @Transactional
    public User save(User user) {
        if (user.getId() == null) {
            manager.persist(user);
        } else {
            manager.merge(user);
        }
        return user;
    }

    @Override
    public User getById(Integer id) {
        return manager.find(User.class, id);
    }
}
