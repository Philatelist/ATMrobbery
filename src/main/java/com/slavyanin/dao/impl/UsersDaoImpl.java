package com.slavyanin.dao.impl;

import com.slavyanin.dao.UsersDao;
import com.slavyanin.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UsersDaoImpl implements UsersDao {
    protected final Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

//    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Users> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, new RowMapper<Users>() {

            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                return getUser(resultSet);
            }
        });
    }

    public Users findById(Long id) {
        Users user = null;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, new RowMapper<Users>() {

                public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getUser(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return user;
    }

    public Users findByName(String name) {
        Object[] objects = new Object[]{name};
        Users user = null;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, objects, new RowMapper<Users>() {

                public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getUser(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return user;
    }


    public Long insert(final Users user) {
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT, new  String[] {Users.ID_COLUMN});
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().longValue();
    }


    public void update(Users user) {
        Object[] objects = new Object[] {
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getId()
        };
        jdbcTemplate.update(SQL_UPDATE, objects);

    }


    public void delete(Users user) {
        Object[] objects = new Object[] {
                user.getEmail()
        };
        jdbcTemplate.update(SQL_DELETE, objects);
    }

    private Users getUser(ResultSet resultSet) throws SQLException {
        Users user = new Users();
        user.setId(resultSet.getLong(Users.ID_COLUMN));
        user.setName(resultSet.getString(Users.NAME_COLUMN));
        user.setEmail(resultSet.getString(Users.EMAIL_COLUMN));
        return user;
    }
}
