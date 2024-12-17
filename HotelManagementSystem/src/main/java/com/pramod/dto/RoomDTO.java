package com.pramod.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {
	private long id;
	private String roomType;
	private String roomPrice;
	private String roomDescription;
	private List<BookingDTO> bookings;
	
	public List<BookingDTO> getBookings() {
		return bookings;
	}
	public void setBookings(List<BookingDTO> bookings) {
		this.bookings = bookings;
	}
	private String roomPhoto;
	public long getId() {
		return id;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomPhoto() {
		return roomPhoto;
	}
	public void setRoomPhoto(String roomPhoto) {
		this.roomPhoto = roomPhoto;
	}
	
	
	

	

}
