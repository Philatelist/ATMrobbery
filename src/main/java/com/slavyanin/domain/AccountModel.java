package com.slavyanin.domain;

import java.util.Map;

public class AccountModel {

    private Map<String, Integer> bankAccount;

    private Map<String, String> usersNameAndEmail;

    private Map<String, String> usersNameandPassword;

    public AccountModel(String name, String email, String password) {
        this.usersNameAndEmail.put(name, email);
        this.usersNameandPassword.put(name, password);
        this.bankAccount.put(email, 50000);
    }

    public Map<String, Integer> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Map<String, Integer> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Map<String, String> getUsersNameAndEmail() {
        return usersNameAndEmail;
    }

    public void setUsersNameAndEmail(Map<String, String> usersNameAndEmail) {
        this.usersNameAndEmail = usersNameAndEmail;
    }

    public Map<String, String> getUsersNameandPassword() {
        return usersNameandPassword;
    }

    public void setUsersNameandPassword(Map<String, String> usersNameandPassword) {
        this.usersNameandPassword = usersNameandPassword;
    }

    public void fillUserBallance(String admin, String userId) {
        if (admin == "admin") {
            this.bankAccount.put(userId, 50000);
        }
    }
}
