package com.Practica.pruebaapisql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Practica.pruebaapisql.domain.User;
import com.Practica.pruebaapisql.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> showAll() {
        List<User> lista;
        lista = userService.getAll();
        return lista;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        User usuario;
        usuario = userService.getById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUserPost(@Valid @RequestBody User usuario) {
        User usuarioAnhadido = userService.addUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioAnhadido);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> editUserPut(@PathVariable Long id, @Valid @RequestBody User usuarioModificado) {
        if (id != usuarioModificado.getId()) {
            return ResponseEntity.badRequest().build();
        }
        User usuario;
        usuario = userService.getById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        userService.edit(usuarioModificado);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModificado);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
