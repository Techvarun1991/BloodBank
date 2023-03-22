package com.product.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.product.entity.Appointments;
import com.product.entity.Blood;
import com.product.entity.Requests;
import com.product.entity.Requests;
import com.product.entity.User;
import com.product.repository.AppointmentRepository;
import com.product.repository.RequestRepository;
import com.product.repository.StockRepository;
import com.product.repository.UserRepository;
import com.product.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private RequestRepository requestRepo;
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String register() {
		return "register";	
	}
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
	
	@PostMapping("/register")
	public String createUser(@ModelAttribute User user , HttpSession session){
		
		boolean b = userService.checkEmail(user.getEmail());
//		boolean m = userService.checkMobile_no(user.getMobile_no());
		if(b) {
			session.setAttribute("msg", "Email id Already Exists");
		}
		else { 
			userService.create(user);
			session.setAttribute("msg", "Registered Succesfully !!");
			return "redirect:/signin";
		}
		return "redirect:/register";
			
	}
	
	
//	@GetMapping("/edit_form")
//	public String editForm()
//	{
//		return "request_update";
//	}
	
	
	
	@GetMapping("/delete/{id}")
	public String deleteProducts(@PathVariable(value = "id") int id, HttpSession session) {
		System.out.println(id);
		requestRepo.deleteById(id);
		session.setAttribute("msg", "Request Delete Sucessfully..");
		
		return "redirect:/request_details";

	}
	

	
	
	
	
	
}
