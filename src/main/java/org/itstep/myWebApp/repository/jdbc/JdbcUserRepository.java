package org.itstep.myWebApp.repository.jdbc;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {

/*    private SimpleJdbcInsert insert;

    public JdbcUserRepository(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingColumns("id");
    }*/

    private final BeanPropertyRowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<User> getAll() {
        return template.query("SELECT *FROM users", rowMapper);
    }

    @Override
    public boolean delete(Integer id) {
        int update = template.update("DELETE FROM users WHERE users.id=?", id);
        return update > 0 ? true : false;
    }

    @Override
    public User save(User user) {
/*        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", user.getName());
        map.addValue("lastName", user.getLastname());
        map.addValue("city", user.getCity());
        map.addValue("email", user.getEmail());

        if (user.getId() == null) {
            Number num = insert.executeAndReturnKey(map);
            user.setId(num.intValue());
        } else {
            map.addValue("id", user.getId());
            int update = template.update("UPDATE users SET name=:name, lastname=:lastname, city=:city, email=:email WHERE id=:id", map);
        }
        return user;*/

        int update = template.update("INSERT INTO users (Name, lastName, city, email) VALUES(?, ?, ?, ?)",
                user.getName(),
                user.getLastname(),
                user.getCity(),
                user.getEmail()
        );
        return update == 0 ? null : user;
    }

    @Override
    public User getById(Integer id) {
        return template.queryForObject("SELECT *FROM users WHERE users.id=?", rowMapper, id);
    }
}
