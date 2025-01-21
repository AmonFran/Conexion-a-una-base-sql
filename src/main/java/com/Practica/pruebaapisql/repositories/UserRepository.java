package com.Practica.pruebaapisql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Practica.pruebaapisql.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

}