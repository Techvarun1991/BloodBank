package com.product.service;

import com.product.entity.User;

public interface UserService {
	
	void create(User user);
	public boolean checkEmail(String email);
//	public boolean checkMobile_no(String mobile_no);
	
}
