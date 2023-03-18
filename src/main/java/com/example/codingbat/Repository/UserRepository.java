package com.example.codingbat.Repository;

import com.example.codingbat.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmailOrPassword(String email, String password);
}
