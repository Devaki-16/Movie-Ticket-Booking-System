package com.spring.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ShowDto {
    
    private Long showId;
    private MovieDto movie;
    private ScreenDto screen;
    private LocalDateTime showTime;
	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public MovieDto getMovie() {
		return movie;
	}
	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}
	public ScreenDto getScreen() {
		return screen;
	}
	public void setScreen(ScreenDto screen) {
		this.screen = screen;
	}
	public LocalDateTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}
	public ShowDto(Long showId, MovieDto movie, ScreenDto screen, LocalDateTime showTime) {
		super();
		this.showId = showId;
		this.movie = movie;
		this.screen = screen;
		this.showTime = showTime;
	}
	public ShowDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
