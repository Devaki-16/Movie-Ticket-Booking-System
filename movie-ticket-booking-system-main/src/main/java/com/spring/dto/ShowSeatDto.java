package com.spring.dto;

import com.spring.enums.SeatStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ShowSeatDto {
    private Long id;
    private ShowDto show;
    private SeatDto seat;
    private SeatStatus status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ShowDto getShow() {
		return show;
	}
	public void setShow(ShowDto show) {
		this.show = show;
	}
	public SeatDto getSeat() {
		return seat;
	}
	public void setSeat(SeatDto seat) {
		this.seat = seat;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	public ShowSeatDto(Long id, ShowDto show, SeatDto seat, SeatStatus status) {
		super();
		this.id = id;
		this.show = show;
		this.seat = seat;
		this.status = status;
	}
	public ShowSeatDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
