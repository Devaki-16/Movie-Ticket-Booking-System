package com.spring.repositary;

import com.spring.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepositary extends JpaRepository<Screen,Long> {
}