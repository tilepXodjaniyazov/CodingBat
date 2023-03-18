package com.example.codingbat.Repository;

import com.example.codingbat.Entity.TaskCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCaseRepository extends JpaRepository<TaskCase,Integer> {

}
