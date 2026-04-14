package com.spring.repositary;

import com.spring.entity.ShowSeat;
import com.spring.enums.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepositary extends JpaRepository<ShowSeat,Long> {
    List<ShowSeat> findByShow_ShowId(Long showId);

    List<ShowSeat> findByShow_ShowIdAndStatus(
            Long showId,
            SeatStatus status
    );

    Optional<ShowSeat> findByShow_ShowIdAndSeat_SeatId(
            Long showId,
            Long seatId
    );
}
