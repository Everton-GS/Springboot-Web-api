package com.example.Projectwebapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Projectwebapi.entitys.Users;

public interface RespositoryUsers extends JpaRepository<Users,Long> {
    
}
