package com.slavyanin.dao.impl;

import com.slavyanin.dao.AccountsDao;
import com.slavyanin.model.Accounts;
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

public class AccountsDaoImpl implements AccountsDao {
    protected final Logger logger = LoggerFactory.getLogger(AccountsDaoImpl.class);

    private JdbcTemplate jdbcTemplate;

    public List<Accounts> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, new RowMapper<Accounts>() {

            public Accounts mapRow(ResultSet resultSet, int i) throws SQLException {
                return getAccount(resultSet);
            }
        });
    }

    public Accounts findById(Long id) {
        Accounts account = null;
        try {
            account = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, new RowMapper<Accounts>() {

                public Accounts mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getAccount(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return account;
    }

    public Accounts findByBallance(Long ballance) {
        Object[] objects = new Object[]{ballance};
        Accounts account = null;
        try {
            account = jdbcTemplate.queryForObject(SQL_FIND_BY_BALLANCE, objects, new RowMapper<Accounts>() {

                public Accounts mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getAccount(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return account;
    }

    public Long insert(final Accounts account) {
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT, new  String[] {Users.ID_COLUMN});
                ps.setLong(1, account.getBallance());
                ps.setDate(2, account.getLastModified());
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public void update(Accounts account) {
        Object[] objects = new Object[] {
                account.getBallance(),
                account.getLastModified(),
                account.getId()
        };
        jdbcTemplate.update(SQL_UPDATE, objects);
    }

    public void delete(Accounts account) {
        Object[] objects = new Object[] {
                account.getId()
        };
        jdbcTemplate.update(SQL_DELETE, objects);
    }

    private Accounts getAccount(ResultSet resultSet) throws SQLException {
        Accounts account = new Accounts();
        account.setId(resultSet.getLong(Accounts.ID_COLUMN));
        account.setBallance(resultSet.getLong(Accounts.BALLANCE_COLUMN));
        account.setLastModified(resultSet.getDate(Accounts.LAST_MODIFIED_COLUMN));
        return account;
    }
}




