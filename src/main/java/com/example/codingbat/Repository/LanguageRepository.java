package com.example.codingbat.Repository;
import com.example.codingbat.Entity.Language;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
    boolean existsByName(String name);
}
