package com.spring.service;

import com.spring.dto.ShowSeatDto;

import java.util.List;

public interface ShowSeatService {
    void createShowSeats(Long showId);
    List<ShowSeatDto> getSeatsByShow(Long showId);
    List<ShowSeatDto> getAvailableSeats(Long showId);
    void lockSeats(Long showId, List<Long> seatIds);
    void confirmSeats(Long showId, List<Long> seatIds);
    void releaseSeats(Long showId, List<Long> seatIds);


}
