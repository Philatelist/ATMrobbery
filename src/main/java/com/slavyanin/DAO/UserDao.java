package com.slavyanin.DAO;

import com.slavyanin.model.User;

import java.util.List;

public interface UserDao {
    public static final String COMMA = ", ";

    public static final String SQL_FIND_ALL = "SELECT * FROM " + User.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " WHERE " + User.ID_COLUMN + " = ?";
    public static final String SQL_FIND_BY_NAME = SQL_FIND_ALL + " WHERE " + User.NAME_COLUMN + " = ?";
    public static final String SQL_INSERT = "INSERT INTO " + User.TABLE_NAME + " (" + User.NAME_COLUMN + ", " + User.EMAIL_COLUMN + ", " + User.PASSW_COLUMN + ", " + User.BALLANCE_COLUMN + ") VALUES (?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE " + User.TABLE_NAME + " SET " + User.NAME_COLUMN + " = ?" + COMMA + User.EMAIL_COLUMN + " = ?" + COMMA + User.PASSW_COLUMN + " = ?" + " WHERE " + User.ID_COLUMN + " = ?";
    public static final String SQL_UPDATE_BALLANCE_BYEMAIL = "UPDATE " + User.TABLE_NAME + " SET "  + User.BALLANCE_COLUMN + " = ?"+ " WHERE " + User.EMAIL_COLUMN + " = ?";
    public static final String SQL_DELETE = "DELETE FROM " + User.TABLE_NAME + " WHERE " + User.ID_COLUMN + " = ?";

    public List<User> findAll();
    public User findById(Long id);
    public User findByName(String name);
    public Long insert(User user);
    public void update(User user);
    public void updateBallance(User user);
    public void delete(User user);
}
