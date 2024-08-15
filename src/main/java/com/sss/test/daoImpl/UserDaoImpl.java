package com.sss.test.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sss.test.dao.UserDao;
import com.sss.test.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY user_id",
                new BeanPropertyRowMapper<User>(User.class));
    }

    public User findByLoginIdAndPassword(String login_id, String password) {
        List<User> readList = jdbcTemplate.query(
                "SELECT * FROM users WHERE login_id = :login_id AND password = :password", new MapSqlParameterSource()
                        .addValue("login_id", login_id)
                        .addValue("password", password),
                new BeanPropertyRowMapper<User>(User.class));
        return readList.isEmpty() ? null : readList.get(0);
    }

    public int insertUser(User user) {
        LocalDateTime now = LocalDateTime.now();
        int insertResult = jdbcTemplate.update(
                "INSERT INTO users (login_id, name, password, role, created_datetime, updated_datetime) VALUES (:login_id, :name, :password, :role, :now, :now)",
                new MapSqlParameterSource()
                        .addValue("login_id", user.getLoginId())
                        .addValue("name", user.getName())
                        .addValue("password", user.getPasword())
                        .addValue("role", user.getRole())
                        .addValue("now", now));
        return insertResult;
    }

}
