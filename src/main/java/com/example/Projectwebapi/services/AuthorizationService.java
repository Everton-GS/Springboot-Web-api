package com.example.Projectwebapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Projectwebapi.repositories.UsersRespository;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsersRespository usersRespository;

    

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        
       return usersRespository.findByLogin(login);
    }
    
}
