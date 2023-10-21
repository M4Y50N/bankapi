package br.com.m4y50n.bankapi.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends _Base {
    @Column(length = 92, nullable = false)
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 62, nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String password;

    // @OneToOne(mappedBy = "user")
    // private Account account;

    // @OneToMany(mappedBy = "user")
    // private List<BusinessAccount> business_accounts = new ArrayList<>();

    public User(String name, String cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
