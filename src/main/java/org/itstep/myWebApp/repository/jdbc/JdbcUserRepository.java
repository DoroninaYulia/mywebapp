package org.itstep.myWebApp.repository.jdbc;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {

    private final BeanPropertyRowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    private SimpleJdbcInsert insert;

    @Autowired
    public JdbcUserRepository(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users", rowMapper);
    }

    @Override
    public boolean delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM users WHERE users.id=?", id) > 0;
    }

    @Override
    public User save(User user) {

        System.out.println(user);

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", user.getName());
        map.addValue("lastname", user.getLastname());
        map.addValue("city", user.getCity());
        map.addValue("email", user.getEmail());

        if (user.getId() == null) {
            Number number = insert.executeAndReturnKey(map);
            user.setId(number.intValue());
        } else {
            map.addValue("id", user.getId());
            namedParameterJdbcTemplate
                    .update("UPDATE users SET name=:name, lastname=:lastname, city=:city, email=:email " +
                            "WHERE id=:id", map);
        }

        System.out.println(user);

        return user;
    }

    @Override
    public User getById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE users.id=?", rowMapper, id);
    }
}
