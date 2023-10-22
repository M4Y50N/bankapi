package br.com.m4y50n.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.m4y50n.bankapi.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
