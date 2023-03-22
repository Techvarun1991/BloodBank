package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "appointment_name")
	private String appointment_name;
	
	private String mobileno;
	private String date;
	private String time;
	
	public Appointments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointments(String appointment_name, String mobileno, String date, String time) {
		super();
		this.appointment_name = appointment_name;
		this.mobileno = mobileno;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getAppointment_name() {
		return appointment_name;
	}

	public void setAppointment_name(String appointment_name) {
		this.appointment_name = appointment_name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Appointments [id=" + id + ", appointmentName=" + appointment_name + ", mobileno=" + mobileno + ", date="
				+ date + ", time=" + time + "]";
	}

	
}