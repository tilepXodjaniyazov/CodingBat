package com.example.codingbat.Repository;

import com.example.codingbat.Entity.CompletedTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedTaskRepository extends JpaRepository<CompletedTask,Integer> {

}
