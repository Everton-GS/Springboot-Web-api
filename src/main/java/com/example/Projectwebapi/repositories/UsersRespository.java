package com.example.Projectwebapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Projectwebapi.entitys.Users;

public interface UsersRespository extends JpaRepository<Users,Long> {
  
   UserDetails findbyLogin(String login);
}
