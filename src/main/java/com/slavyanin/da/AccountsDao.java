package com.slavyanin.da;

import com.slavyanin.model.Accounts;

import java.util.List;

public interface AccountsDao {
    public static final String COMMA = ", ";

    public static final String SQL_FIND_ALL = "SELECT * FROM " + Accounts.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " WHERE " + Accounts.ID_COLUMN + " = ?";
    public static final String SQL_FIND_BY_BALLANCE = SQL_FIND_ALL + " WHERE " + Accounts.BALLANCE_COLUMN + " = ?";
    public static final String SQL_INSERT = "INSERT INTO " + Accounts.TABLE_NAME + " (" + Accounts.BALLANCE_COLUMN + ", " + Accounts.LAST_MODIFIED_COLUMN + ") VALUES (?, ?)";
    public static final String SQL_UPDATE = "UPDATE " + Accounts.TABLE_NAME + " SET " + Accounts.BALLANCE_COLUMN + " = ?" + COMMA + Accounts.LAST_MODIFIED_COLUMN + " = ?" + " WHERE " + Accounts.ID_COLUMN + " = ?";
    public static final String SQL_DELETE = "DELETE FROM " + Accounts.TABLE_NAME + " WHERE " + Accounts.ID_COLUMN + " = ?";

    public List<Accounts> findAll();
    public Accounts findById(Long id);
    public Accounts findByBallance(Long ballance);
    public Long insert(Accounts account);
    public void update(Accounts account);
    public void delete(Accounts account);
}
