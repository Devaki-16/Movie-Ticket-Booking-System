package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.enums.SeatStatus;
import jakarta.persistence.*;


@Entity
@Table(
        name = "show_seats",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"show_id", "seat_id"})
        }
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Seat seat;

    public Long getId() {
		return id;
	}

	public ShowSeat(Long id, Show show, Seat seat, SeatStatus status) {
		super();
		this.id = id;
		this.show = show;
		this.seat = seat;
		this.status = status;
	}

	public ShowSeat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}

	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status;
}
