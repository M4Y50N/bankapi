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
}
