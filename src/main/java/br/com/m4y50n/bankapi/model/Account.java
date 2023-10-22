package br.com.m4y50n.bankapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account extends _Base {
    private enum AccountType {
        CC,
        CP
    }

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(columnDefinition = "DECIMAL DEFAULT 0.0")
    private Double balance;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Account(AccountType type, User user) {
        this.type = type;
        this.user = user;
    }

    public Account() {
    }

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
