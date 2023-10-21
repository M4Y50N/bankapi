package br.com.m4y50n.bankapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account extends Base {
    public Account(AccountType type, Double balance, User user) {
        this.type = type;
        this.balance = balance;
        this.user = user;
    }

    public enum AccountType {
        CC,
        CP
    }

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(columnDefinition = "DECIMAL(10, 2) DEFAULT 0")
    private Double balance;

    @OneToOne
    private User user;

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
