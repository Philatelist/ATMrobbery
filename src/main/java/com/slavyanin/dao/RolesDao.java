package com.slavyanin.dao;

import com.slavyanin.model.Roles;

import java.util.List;

public interface RolesDao {
    public static final String COMMA = ", ";

    public static final String SQL_FIND_ALL = "SELECT * FROM " + Roles.TABLE_NAME;
    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " WHERE " + Roles.ID_COLUMN + " = ?";
    public static final String SQL_FIND_BY_NAME = SQL_FIND_ALL + " WHERE " + Roles.NAME_COLUMN + " = ?";
    public static final String SQL_INSERT = "INSERT INTO " + Roles.TABLE_NAME + " (" + Roles.NAME_COLUMN + ") VALUES (?)";
    public static final String SQL_UPDATE = "UPDATE " + Roles.TABLE_NAME + " SET " + Roles.NAME_COLUMN + " = ?" + " WHERE " + Roles.ID_COLUMN + " = ?";
    public static final String SQL_DELETE = "DELETE FROM " + Roles.TABLE_NAME + " WHERE " + Roles.ID_COLUMN + " = ?";

    public List<Roles> findAll();
    public Roles findById(Long id);
    public Roles findByName(String name);
    public Long insert(Roles roles);
    public void update(Roles roles);
    public void delete(Roles roles);
}
