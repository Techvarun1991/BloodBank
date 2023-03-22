package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="stock_data")
public class Blood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String bloodType;
	private int qty;
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Blood() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blood(int id, String bloodType, int qty) {
		super();
		this.id = id;
		this.bloodType = bloodType;
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Blood [id=" + id + ", bloodType=" + bloodType + ", qty=" + qty + "]";
	}
	
	

}
