package com.spring.mapper;

import com.spring.dto.TheatreDto;
import com.spring.entity.Theatre;


public class TheatreMapper {

    public static TheatreDto toDto(Theatre theatre) {
        if (theatre == null) return null;

        TheatreDto dto = new TheatreDto();
        dto.setTheatreId(theatre.getTheatreId());
        dto.setName(theatre.getName());
        dto.setCity(theatre.getCity());

        // Map screens → screenDto → seats
        /*if (theatre.getScreens() != null) {
            dto.setScreens(
                    theatre.getScreens()
                            .stream()
                            .map(ScreenMapper::toDto)
                            .collect(Collectors.toList())
            );
        }*/

        return dto;
    }

    public static Theatre toEntity(TheatreDto dto) {
        if (dto == null) return null;

        Theatre theatre = new Theatre();
        theatre.setTheatreId(dto.getTheatreId());
        theatre.setName(dto.getName());
        theatre.setCity(dto.getCity());

        return theatre;
    }
}
