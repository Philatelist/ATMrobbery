package com.slavyanin.da;

import com.slavyanin.model.Users;

import java.util.List;

public interface UsersDao {
    public static final String COMMA = ", ";

    public static final String SQL_FIND_ALL = "SELECT * FROM " + Users.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " WHERE " + Users.ID_COLUMN + " = ?";
    public static final String SQL_FIND_BY_NAME = SQL_FIND_ALL + " WHERE " + Users.NAME_COLUMN + " = ?";
    public static final String SQL_INSERT = "INSERT INTO " + Users.TABLE_NAME + " (" + Users.NAME_COLUMN + ", " + Users.EMAIL_COLUMN + ", " + Users.PASSW_COLUMN + ") VALUES (?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE " + Users.TABLE_NAME + " SET " + Users.NAME_COLUMN + " = ?" + COMMA + Users.EMAIL_COLUMN + " = ?" + COMMA + Users.PASSW_COLUMN + " = ?" + " WHERE " + Users.ID_COLUMN + " = ?";
    public static final String SQL_DELETE = "DELETE FROM " + Users.TABLE_NAME + " WHERE " + Users.ID_COLUMN + " = ?";

    public List<Users> findAll();
    public Users findById(Long id);
    public Users findByName(String name);
    public Long insert(Users user);
    public void update(Users user);
    public void delete(Users user);
}
