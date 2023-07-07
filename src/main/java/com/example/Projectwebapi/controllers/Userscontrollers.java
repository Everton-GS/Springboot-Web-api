package com.example.Projectwebapi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Projectwebapi.entitys.Users;
import com.example.Projectwebapi.repositories.UsersRespository;


@RestController
@RequestMapping(value = "/")
public class Userscontrollers {
  
  @Autowired
  UsersRespository usersrespository;

  @Autowired
  PasswordEncoder encoder;

   @PostMapping("cadastrar")
   public Users cadastrar(@RequestBody Users users){
    users.setSenha(encoder.encode(users.getSenha()));
    return usersrespository.save(users);
   }

    @GetMapping
    public List<Users>listar(){
        return usersrespository.findAll();
        
    }
    
}
