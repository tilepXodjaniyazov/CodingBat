package com.example.codingbat.Repository;

import com.example.codingbat.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
}
