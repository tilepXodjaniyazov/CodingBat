package com.example.codingbat.Repository;

import com.example.codingbat.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    boolean existsByName(String name);
}
