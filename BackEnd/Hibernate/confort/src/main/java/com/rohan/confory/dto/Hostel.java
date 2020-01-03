package com.rohan.confory.dto;

import javax.persistence.*;

@Entity
@Table
public class Hostel {
	@Id
	@Column(name="room_id")
	private int roomno;
	
	@Column
	private String name;
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
