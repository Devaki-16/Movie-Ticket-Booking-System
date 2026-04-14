package com.spring.mapper;

import com.spring.dto.SeatDto;
import com.spring.entity.Seat;

public class SeatMapper {

    public static SeatDto toDto(Seat seat) {
        if (seat == null) return null;

        SeatDto dto = new SeatDto();
        dto.setSeatId(seat.getSeatId());
        dto.setSeatNumber(seat.getSeatNumber());
        dto.setSeatType(seat.getSeatType());
        dto.setPrice(seat.getPrice());

        // IMPORTANT: do NOT map full Screen here

        dto.setScreen(ScreenMapper.toDto(seat.getScreen()));

        return dto;
    }

    public static Seat toEntity(SeatDto dto) {
        if (dto == null) return null;

        Seat seat = new Seat();
        seat.setSeatId(dto.getSeatId());
        seat.setSeatNumber(dto.getSeatNumber());
        seat.setSeatType(dto.getSeatType());
        seat.setPrice(dto.getPrice());

        return seat;
    }
}
