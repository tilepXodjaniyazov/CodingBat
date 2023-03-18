package com.example.codingbat.Repository;

import com.example.codingbat.Entity.UserStarCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStarCountRepository extends JpaRepository<UserStarCount,Integer> {
}
