package com.spring.mapper;

import com.spring.dto.ScreenDto;
import com.spring.entity.Screen;


public class ScreenMapper {

    public static ScreenDto toDto(Screen screen) {
        if (screen == null) return null;

        ScreenDto dto = new ScreenDto();
        dto.setScreenId(screen.getScreenId());
        dto.setScreenNumber(screen.getScreenNumber());
        dto.setTheatreDto(TheatreMapper.toDto(screen.getTheatre()));

        return dto;
    }

    public static Screen toEntity(ScreenDto dto) {
        if (dto == null) return null;

        Screen screen = new Screen();
        screen.setScreenId(dto.getScreenId());
        screen.setScreenNumber(dto.getScreenNumber());
        screen.setTheatre(TheatreMapper.toEntity(dto.getTheatreDto()));

        return screen;
    }
}
