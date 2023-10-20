package br.com.m4y50n.bankapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account extends Base {
    private AccountType type;

    public enum AccountType {
        CC,
        CP
    }

    private long userId;
}
