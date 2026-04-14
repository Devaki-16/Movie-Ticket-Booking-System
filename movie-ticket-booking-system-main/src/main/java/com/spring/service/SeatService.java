package com.spring.service;

import java.util.List;

import com.spring.dto.SeatDto;

public interface SeatService {

    SeatDto addSeat(SeatDto seatDto,Long screenId);
    List<SeatDto> getAllSeatsByScreenId(Long screenId);
    SeatDto updateSeat(Long id,SeatDto seatDto);
    List<SeatDto> addSeatsInBulk(Long screenId, List<SeatDto> seats);
    SeatDto deleteSeat(Long screenId, Long seatId);
}