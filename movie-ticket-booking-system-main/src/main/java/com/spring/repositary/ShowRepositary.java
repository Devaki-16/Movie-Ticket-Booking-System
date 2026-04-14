package com.spring.repositary;
import com.spring.entity.Show;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepositary extends JpaRepository<Show,Long> {

    List<Show> findByMovie_TitleContainingIgnoreCase(String movieTitle);

    List<Show> findByScreen_Theatre_CityAndMovie_Title(
        String city,
        String title
);

List<Show> findByMovie_TitleAndScreen_Theatre_City(@Param("movieTitle") String movieTitle,
                                            @Param("city") String city);
}