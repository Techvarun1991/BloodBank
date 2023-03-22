package com.product.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.entity.Appointments;
import com.product.entity.Requests;
import com.product.entity.User;
import com.product.repository.AppointmentRepository;
import com.product.repository.RequestRepository;
import com.product.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RequestRepository requestRepo;
	
	@Autowired
	private AppointmentRepository appointmentRepo;

	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}

	@GetMapping("/")
	public String home() {
		return "user/home";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "user/profile";
	}
	
	
	@GetMapping("/request_add/{id}")
	public String loadForm(@PathVariable(value = "id") int id , Model m )
	{
		User user = userRepo.findById(id);
		m.addAttribute("user",user); 	
		return "user/request_add";
	}
	
	@PostMapping("/save_requests")
	public String saveProducts(@ModelAttribute Requests requests, HttpSession session) {

		requestRepo.save(requests);
		session.setAttribute("msg", "Request Added Sucessfully..");

		return "redirect:/user/request_add";
	}
	
	
	@GetMapping("/appointment_add")
	public String loadForm1()
	{
		return "user/appointment_add";
	}
	
	
	@PostMapping("/save_appointments")
	public String saveProducts(@ModelAttribute Appointments appointments, HttpSession session) {

		appointmentRepo.save(appointments);
		session.setAttribute("msg", "Appointment Added Sucessfully..");

		return "redirect:/user/";
	}
	
	
//	@GetMapping("/request_status/{id}")
//	public String home5(@PathVariable(value = "id") int id, Model m)
//	{
//	  List<Requests> list =	requestRepo.findByUserId(id);
//		m.addAttribute("requestlist1",list); 	
//		return "user/request_status";
//		}	
}
	
//	@GetMapping("/approve_form/{id}")
//	public String editForm(@PathVariable(value = "id") int id, Model m) {
//
//		Optional<Requests> request = requestRepo.findById(id);
//
//		Requests res = request.get();
//		m.addAttribute("request", res);
//
//		return "admin/request_approved";
//	}
	
	
	


