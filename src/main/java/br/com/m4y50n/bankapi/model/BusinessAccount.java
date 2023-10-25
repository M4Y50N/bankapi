package br.com.m4y50n.bankapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "business_accounts")
public class BusinessAccount extends _Base {
    @Column(length = 92, nullable = false)
    private String bussinessName;

    @Column(columnDefinition = "DECIMAL(10, 2) DEFAULT 0.0", nullable = false)
    private Double balance;

    @Column(length = 155, nullable = false)
    private String role;

    @Column(length = 14, nullable = false)
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public BusinessAccount(String bussinessName, String role, String cnpj, User user) {
        this.bussinessName = bussinessName;
        this.role = role;
        this.cnpj = cnpj;
        this.user = user;
    }

    public BusinessAccount() {
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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