package br.com.m4y50n.bankapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction extends _Base {
    @ManyToOne
    @JoinColumn(name = "payer_id", referencedColumnName = "id", nullable = false)
    private Account payer;

    @Column(columnDefinition = "DECIMAL(10, 2) DEFAULT 0.0")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "payee_id", referencedColumnName = "id", nullable = false)
    private Account payee;

    public Transaction(Account payer, double amount, Account payee) {
        this.payer = payer;
        this.amount = amount;
        this.payee = payee;
    }

    public Transaction() {
    }

    public Account getPayee() {
        return payee;
    }

    public void setPayee(Account payee) {
        this.payee = payee;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getPayer() {
        return payer;
    }

    public void setPayer(Account payer) {
        this.payer = payer;
    }
}
