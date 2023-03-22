package com.product.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requests_dtls")
public class Requests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "request_name")
	private String request_name;
	private String mobileno;
	private String blood;
	public Requests(String request_name, String mobileno, String blood, String quantity, String location,
			String status) {
		super();
		this.request_name = request_name;
		this.mobileno = mobileno;
		this.blood = blood;
		this.quantity = quantity;
		this.location = location;
		this.status = status;
	}

	public Requests(User user) {
		super();
		this.user = user;
	}

	private String quantity;
	private String location;
	private String status;
	@OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Requests() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequest_name() {
		return request_name;
	}

	public void setRequest_name(String request_name) {
		this.request_name = request_name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Requests(int id, String request_name, String mobileno, String blood, String quantity, String location,
			String status) {
		super();
		this.id = id;
		this.request_name = request_name;
		this.mobileno = mobileno;
		this.blood = blood;
		this.quantity = quantity;
		this.location = location;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Requests [id=" + id + ", request_name=" + request_name + ", mobileno=" + mobileno + ", blood=" + blood
				+ ", quantity=" + quantity + ", location=" + location + ", status=" + status + "]";
	}

	

	
	

}
