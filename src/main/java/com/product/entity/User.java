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


@Entity
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String upass;
	private String dob;
	@Column(unique = true)
	private String mobile_no;
	private String gender;
	@Column(unique = true)
	private String email;
	private String role;
	@OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "user")
	private Requests req;
	public Requests getReq() {
		return req;
	}
	public void setReq(Requests req) {
		this.req = req;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", upass=" + upass + ", dob=" + dob
				+ ", mobile_no=" + mobile_no + ", gender=" + gender + ", email=" + email + ", role=" + role + ", req="
				+ req + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String fname, String lname, String upass, String dob, String mobile_no, String gender,
			String email, String role, Requests req) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.upass = upass;
		this.dob = dob;
		this.mobile_no = mobile_no;
		this.gender = gender;
		this.email = email;
		this.role = role;
		this.req = req;
	}
}