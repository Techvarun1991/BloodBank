package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.product.entity.User;
import com.product.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
//	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		user.setUpass(passwordEncode.encode(user.getUpass()));
		user.setRole("ROLE_USER");
		userRepo.save(user);
	}

	

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}



//	@Override
//	public boolean checkMobile_no(String mobile_no) {
//		// TODO Auto-generated method stub
//		return userDao.existByMobile_no(mobile_no);
//	}
	
	
}
