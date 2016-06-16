package com.slavyanin.dataAccess;

import com.slavyanin.domain.Users;

import java.util.List;

public interface UsersData {

    public void addUser (Users user);

    public List<Users> listUsers();

    public void fillBallance(Users user);


}
