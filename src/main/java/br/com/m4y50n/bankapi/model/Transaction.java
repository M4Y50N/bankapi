package br.com.m4y50n.bankapi.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Long payee;

    @Column(columnDefinition = "DECIMAL(10, 2)", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User payeer;

    @CreationTimestamp
    @Column(updatable = false)
    private Date transaction_date;

    public Transaction(Long payee, Double amount, User payeer) {
        this.payee = payee;
        this.amount = amount;
        this.payeer = payeer;
    }

    public long getId() {
        return id;
    }

    public Long getPayee() {
        return payee;
    }

    public void setPayee(Long payee) {
        this.payee = payee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getPayeer() {
        return payeer;
    }

    public void setPayeer(User payeer) {
        this.payeer = payeer;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }
}
