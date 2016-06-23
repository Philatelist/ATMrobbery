package com.slavyanin.model;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Table(name = "users")
public class Users {

    public static final String TABLE_NAME = "users";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String EMAIL_COLUMN = "email";
    public static final String PASSW_COLUMN = "password";

    @Id
    @Column(name = ID_COLUMN)
    private Long id;

    @Column(name = NAME_COLUMN)
    private String name;

    @Column(name = EMAIL_COLUMN)
    private String email;

    @Column(name = PASSW_COLUMN)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "roles_id", nullable = false)
    private Roles roles;

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(name="user_account",
            joinColumns = @JoinColumn(name="users_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="accounts_id", referencedColumnName="id")
    )
    private Set<Accounts> accounts;

    public Set<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Accounts> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users user = (Users) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
