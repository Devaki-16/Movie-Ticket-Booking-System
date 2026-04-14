package com.spring.repositary;

import com.spring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepositary extends JpaRepository<Movie,Long> {
    Optional<Movie> findByTitleAndLanguageAndReleaseYear(String title, String language, Integer releaseYear);
    List<Movie> findByTitleContainingIgnoreCase(String title);

}