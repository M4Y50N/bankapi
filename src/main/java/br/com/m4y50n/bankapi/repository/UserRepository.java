package br.com.m4y50n.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.m4y50n.bankapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
