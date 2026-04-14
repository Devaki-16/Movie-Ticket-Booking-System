package com.spring.repositary;

import com.spring.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepositary extends JpaRepository<Theatre,Long> {
    boolean existsByName(String name);
}
