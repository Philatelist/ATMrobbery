package com.slavyanin.da;

import com.slavyanin.model.Atm;

import java.util.List;

public interface AtmDao {
    public static final String COMMA = ", ";

    public static final String SQL_FIND_ALL = "SELECT * FROM " + Atm.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " WHERE " + Atm.ID_COLUMN + " = ?";
    public static final String SQL_FIND_BY_BANKNOTES = SQL_FIND_ALL + " WHERE " + Atm.BANKNOTES_COLUMN + " = ?";
    public static final String SQL_INSERT = "INSERT INTO " + Atm.TABLE_NAME + " (" + Atm.BANKNOTES_COLUMN + ", " + Atm.AMOUNT_COLUMN + ") VALUES (?, ?)";
    public static final String SQL_UPDATE = "UPDATE " + Atm.TABLE_NAME + " SET " + Atm.BANKNOTES_COLUMN + " = ?" + COMMA + Atm.AMOUNT_COLUMN + " = ?" + " WHERE " + Atm.ID_COLUMN + " = ?";
    public static final String SQL_DELETE = "DELETE FROM " + Atm.TABLE_NAME + " WHERE " + Atm.ID_COLUMN + " = ?";

    public List<Atm> findAll();
    public Atm findById(Long id);
    public Atm findByBanknotes(Integer banknotes);
    public Long insert(Atm atm);
    public void update(Atm atm);
    public void delete(Atm atm);
}
