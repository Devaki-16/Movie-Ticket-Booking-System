package com.spring.dto;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ScreenDto {
    private Long screenId;
    private int screenNumber;
    private TheatreDto theatreDto;
	public Long getScreenId() {
		return screenId;
	}
	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}
	public int getScreenNumber() {
		return screenNumber;
	}
	public void setScreenNumber(int screenNumber) {
		this.screenNumber = screenNumber;
	}
	public TheatreDto getTheatreDto() {
		return theatreDto;
	}
	public void setTheatreDto(TheatreDto theatreDto) {
		this.theatreDto = theatreDto;
	}
	public ScreenDto(Long screenId, int screenNumber, TheatreDto theatreDto) {
		super();
		this.screenId = screenId;
		this.screenNumber = screenNumber;
		this.theatreDto = theatreDto;
	}
	public ScreenDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
