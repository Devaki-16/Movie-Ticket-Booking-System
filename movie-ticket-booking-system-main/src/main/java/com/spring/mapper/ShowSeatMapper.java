package com.spring.mapper;

import com.spring.dto.ShowSeatDto;
import com.spring.entity.ShowSeat;

import lombok.extern.slf4j.Slf4j;

public class ShowSeatMapper {

    public static ShowSeatDto toDto(ShowSeat showSeat) {
        if (showSeat == null) return null;

        ShowSeatDto dto = new ShowSeatDto();
        dto.setId(showSeat.getId());
        dto.setStatus(showSeat.getStatus());
        // Minimal mapping to avoid recursion
        dto.setSeat(SeatMapper.toDto(showSeat.getSeat()));
        dto.setShow(ShowMapper.toDto(showSeat.getShow()));

        return dto;
    }

    public static ShowSeat toEntity(ShowSeatDto dto) {
        if (dto == null) return null;

        ShowSeat showSeat = new ShowSeat();
        showSeat.setId(dto.getId());
        showSeat.setStatus(dto.getStatus());

        return showSeat;
    }
}
