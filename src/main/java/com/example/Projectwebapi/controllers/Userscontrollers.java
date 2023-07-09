package com.example.Projectwebapi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Projectwebapi.entitys.Users;
import com.example.Projectwebapi.repositories.UsersRespository;


@RestController
@RequestMapping(value = "/")
public class UsersControllers {
  
  @Autowired
  UsersRespository usersrespository;


    @GetMapping
    public List<Users>listar(){
        return usersrespository.findAll();
        
    }
    
}
