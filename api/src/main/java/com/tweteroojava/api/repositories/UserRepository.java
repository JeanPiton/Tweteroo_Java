package com.tweteroojava.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroojava.api.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

    
}
