package com.spring.repositary;

import com.spring.entity.Seat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepositary extends JpaRepository<Seat,Long> {

    List<Seat> findByScreen_ScreenId(Long screenId);
    boolean existsBySeatNumberAndScreen_ScreenId(String seatNumber, Long screenId);
}