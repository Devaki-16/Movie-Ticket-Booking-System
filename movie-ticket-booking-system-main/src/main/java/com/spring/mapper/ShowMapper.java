package com.spring.mapper;

import com.spring.dto.ShowDto;
import com.spring.entity.Show;

public class ShowMapper {

    public static ShowDto toDto(Show show) {
        if (show == null) return null;

        ShowDto dto = new ShowDto();
        dto.setShowId(show.getShowId());
        dto.setShowTime(show.getShowTime());
        dto.setMovie(MovieMapper.toDto(show.getMovie()));
        dto.setScreen(ScreenMapper.toDto(show.getScreen()));

        return dto;
    }

    public static Show toEntity(ShowDto dto) {
        if (dto == null) return null;

        Show show = new Show();
        show.setShowId(dto.getShowId());
        show.setShowTime(dto.getShowTime());
        show.setMovie(MovieMapper.toEntity(dto.getMovie()));
        show.setScreen(ScreenMapper.toEntity(dto.getScreen()));

        return show;
    }
}
