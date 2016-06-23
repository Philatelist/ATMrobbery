package com.slavyanin.da.impl;

import com.slavyanin.da.RolesDao;
import com.slavyanin.model.Roles;
import com.slavyanin.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RolesDaoImpl implements RolesDao {
    protected final Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

    private JdbcTemplate jdbcTemplate;

    public List<Roles> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, new RowMapper<Roles>() {

            public Roles mapRow(ResultSet resultSet, int i) throws SQLException {
                return getPermission(resultSet);
            }
        });    }

    public Roles findById(Long id) {
        Roles roles = null;
        try {
            roles = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, new RowMapper<Roles>() {

                public Roles mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getPermission(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return roles;    }

    public Roles findByName(String name) {
        Object[] objects = new Object[]{name};
        Roles roles = null;
        try {
            roles = jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, objects, new RowMapper<Roles>() {

                public Roles mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getPermission(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return roles;    }

    public Long insert(final Roles roles) {
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT, new  String[] {Roles.ID_COLUMN});
                ps.setString(1, roles.getName());
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().longValue();    }

    public void update(Roles roles) {
        Object[] objects = new Object[] {
                roles.getName(),
                roles.getId()
        };
        jdbcTemplate.update(SQL_UPDATE, objects);
    }

    public void delete(Roles roles) {
        Object[] objects = new Object[] {
                roles.getId()
        };
        jdbcTemplate.update(SQL_DELETE, objects);
    }

    private Roles getPermission(ResultSet resultSet) throws SQLException {
        Roles roles = new Roles();
        roles.setId(resultSet.getLong(Users.ID_COLUMN));
        roles.setName(resultSet.getString(Users.NAME_COLUMN));
        return roles;
    }
}
