package com.Practica.pruebaapisql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.Practica.pruebaapisql.domain.User;
import com.Practica.pruebaapisql.exceptions.EmptyUserException;
import com.Practica.pruebaapisql.exceptions.UserNotFoundException;
import com.Practica.pruebaapisql.repositories.UserRepository;

@Service
@Primary
public class UserService {
    @Autowired
    UserRepository repositorio;

    public List<User> getAll() {
        List<User> lista = repositorio.findAll();
        if (lista.isEmpty()) {
            throw new EmptyUserException();
        }
        return lista;
    }

    public User getById(Long id) {
        User usuario = repositorio.findById(id).orElse(null);
        return usuario;
    }

    public User addUser(User usuario) {
        return repositorio.save(usuario);
    }

    public User edit(User usuario) {
        return repositorio.save(usuario);
    }

    public void deleteById(Long id){
        repositorio.findById(id).orElseThrow(()->new UserNotFoundException(id));
        repositorio.deleteById(id);
    }
}
