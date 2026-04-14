package com.spring.dto;

import com.spring.enums.SeatType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SeatDto {
    private Long seatId;
    private String seatNumber;
    private SeatType seatType;
    private double price;
    private ScreenDto screen;
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ScreenDto getScreen() {
		return screen;
	}
	public void setScreen(ScreenDto screen) {
		this.screen = screen;
	}
	public SeatDto(Long seatId, String seatNumber, SeatType seatType, double price, ScreenDto screen) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.price = price;
		this.screen = screen;
	}
	public SeatDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
