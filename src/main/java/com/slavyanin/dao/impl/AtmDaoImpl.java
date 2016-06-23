package com.slavyanin.dao.impl;

import com.slavyanin.dao.AtmDao;
import com.slavyanin.model.Atm;
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

public class AtmDaoImpl implements AtmDao {
    protected final Logger logger = LoggerFactory.getLogger(AccountsDaoImpl.class);

    private JdbcTemplate jdbcTemplate;

    public List<Atm> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, new RowMapper<Atm>() {

            public Atm mapRow(ResultSet resultSet, int i) throws SQLException {
                return getAtmInfo(resultSet);
            }
        });
    }

    public Atm findById(Long id) {
        Atm atm = null;
        try {
            atm = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, new RowMapper<Atm>() {

                public Atm mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getAtmInfo(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return atm;    }

    public Atm findByBanknotes(Integer banknotes) {
        Object[] objects = new Object[]{banknotes};
        Atm atm = null;
        try {
            atm = jdbcTemplate.queryForObject(SQL_FIND_BY_BANKNOTES, objects, new RowMapper<Atm>() {

                public Atm mapRow(ResultSet resultSet, int i) throws SQLException {
                    return getAtmInfo(resultSet);
                }
            });
        } catch (EmptyResultDataAccessException e) {
            logger.info("Empty result");
        }
        return atm;    }

    public Long insert(final Atm atm) {
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT, new  String[] {Atm.ID_COLUMN});
                ps.setInt(1, atm.getBanknotes());
                ps.setInt(2, atm.getAmount());
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().longValue();    }

    public void update(Atm atm) {
        Object[] objects = new Object[] {
                atm.getBanknotes(),
                atm.getAmount(),
                atm.getId()
        };
        jdbcTemplate.update(SQL_UPDATE, objects);
    }

    public void delete(Atm atm) {
        Object[] objects = new Object[] {
                atm.getId()
        };
        jdbcTemplate.update(SQL_DELETE, objects);
    }

    private Atm getAtmInfo(ResultSet resultSet) throws SQLException {
        Atm atm = new Atm();
        atm.setId(resultSet.getLong(Atm.ID_COLUMN));
        atm.setBanknotes(resultSet.getInt(Atm.BANKNOTES_COLUMN));
        atm.setAmount(resultSet.getInt(Atm.AMOUNT_COLUMN));
        return atm;
    }
}
