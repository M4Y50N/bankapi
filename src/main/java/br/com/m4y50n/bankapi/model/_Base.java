package br.com.m4y50n.bankapi.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@MappedSuperclass
public class _Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(updatable = false)
    private Date updated_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATE")
    private Date deleted_at;

    public void onDelete() {
        deleted_at = new Date();
    }

    public long getId() {
        return this.id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }
}
