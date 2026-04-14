package com.spring.entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "screens",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"screenNumber", "theatre_id"})
        })

public class Screen {

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

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Screen(Long screenId, int screenNumber, Theatre theatre, List<Seat> seats) {
		super();
		this.screenId = screenId;
		this.screenNumber = screenNumber;
		this.theatre = theatre;
		this.seats = seats;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    private int screenNumber;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;

    public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Screen{" +
                "screenId=" + screenId +
                ", screenNumber=" + screenNumber +
                ", theatre=" + theatre +
                ", seats=" + seats +
                '}';
    }
}
