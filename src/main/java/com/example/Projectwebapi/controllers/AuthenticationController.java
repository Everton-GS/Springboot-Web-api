package com.example.Projectwebapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Projectwebapi.entitys.AuthenticationDTO;
import com.example.Projectwebapi.entitys.RegisterDTO;
import com.example.Projectwebapi.entitys.Users;
import com.example.Projectwebapi.repositories.UsersRespository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  UsersRespository usersRespository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var usernamePassowrd = new UsernamePasswordAuthenticationToken(data.login(),data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassowrd);
        
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
        if(this.usersRespository.findByLogin(data.login())!=null) return ResponseEntity.badRequest().build();

        String encryptedpassword= new BCryptPasswordEncoder().encode(data.senha());
        
        Users user = new Users(data.login(),encryptedpassword,data.role());

        this.usersRespository.save(user);

        return ResponseEntity.ok().build();

        
    }
    
}
