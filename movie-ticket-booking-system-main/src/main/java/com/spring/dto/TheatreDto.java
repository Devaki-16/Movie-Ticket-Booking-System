package com.spring.dto;


import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class TheatreDto {
    private Long theatreId;
    private String name;
    private String city;
	public Long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public TheatreDto(Long theatreId, String name, String city) {
		super();
		this.theatreId = theatreId;
		this.name = name;
		this.city = city;
	}
	public TheatreDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}
