package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.enums.SeatType;
import jakarta.persistence.*;


@Entity
@Table(
        name = "seats",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"seatNumber", "screen_id"})
        }
)

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;


    public Seat(Long seatId, String seatNumber, SeatType seatType, double price, Screen screen) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.price = price;
		this.screen = screen;
	}

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

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
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

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	private double price;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    @JsonIgnore
    private Screen screen;
}
