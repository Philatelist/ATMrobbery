package com.slavyanin.DAO;

import com.slavyanin.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserDaoImpl implements UserDao {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<User> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, new RowMapper<User>() {

            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return getUser(resultSet);
            }
        });
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(User.ID_COLUMN));
        user.setName(resultSet.getString(User.NAME_COLUMN));
        user.setEmail(resultSet.getString(User.EMAIL_COLUMN));
        user.setBallance(resultSet.getLong(User.BALLANCE_COLUMN));
        return user;
    }

    public User findById(Long id) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, new RowMapper<User>() {

                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getUser(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return user;
    }


    public User findByName(String name) {
        Object[] objects = new Object[]{name};
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, objects, new RowMapper<User>() {

                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getUser(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return user;
    }


    public Long insert(final User user) {
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT, new  String[] {User.ID_COLUMN});
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setLong(4, user.getBallance());
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().longValue();
    }


    public void update(User user) {
        Object[] objects = new Object[] {
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getId()
        };
        jdbcTemplate.update(SQL_UPDATE, objects);

    }

    public void updateBallance(User user) {
        Object[] objects = new Object[] {
                user.getBallance(),
                user.getEmail()
        };
        jdbcTemplate.update(SQL_UPDATE_BALLANCE_BYEMAIL, objects);
    }

    public void delete(User user) {
        Object[] objects = new Object[] {
                user.getEmail()
        };
        jdbcTemplate.update(SQL_DELETE, objects);
    }
}
