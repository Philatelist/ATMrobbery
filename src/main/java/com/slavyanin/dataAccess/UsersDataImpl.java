package com.slavyanin.dataAccess;

import com.slavyanin.domain.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersDataImpl implements UsersData {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<Users> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from Users")
                .list();
    }

    @Override
    public void fillBallance(Users user) {

    }
}
