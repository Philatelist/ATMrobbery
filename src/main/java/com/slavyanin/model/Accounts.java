package com.slavyanin.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Accounts {

    public static final String TABLE_NAME = "accounts";
    public static final String ID_COLUMN = "id";
    public static final String BALLANCE_COLUMN = "ballance";
    public static final String LAST_MODIFIED_COLUMN = "last_modified";
    public static final String USER_ID_COLUMN = "user_id";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = BALLANCE_COLUMN)
    private Long ballance;

    @Column(name = LAST_MODIFIED_COLUMN)
    private Date lastModified;

    @Column(name = USER_ID_COLUMN)
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBallance() {
        return ballance;
    }

    public void setBallance(Long ballance) {
        this.ballance = ballance;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Users> users;

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accounts accounts = (Accounts) o;

        if (ballance != null ? !ballance.equals(accounts.ballance) : accounts.ballance != null) return false;
        if (lastModified != null ? !lastModified.equals(accounts.lastModified) : accounts.lastModified != null) return false;
        return user_id != null ? user_id.equals(accounts.user_id) : accounts.user_id == null;

    }

    @Override
    public int hashCode() {
        int result = ballance != null ? ballance.hashCode() : 0;
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", ballance=" + ballance +
                ", lastModified=" + lastModified +
                ", user_id=" + user_id +
                '}';
    }
}
