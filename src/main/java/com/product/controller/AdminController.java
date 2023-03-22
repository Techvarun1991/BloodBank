package com.product.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.entity.Appointments;
import com.product.entity.Blood;
import com.product.entity.Requests;
import com.product.entity.User;
import com.product.repository.AppointmentRepository;
import com.product.repository.RequestRepository;
import com.product.repository.StockRepository;
import com.product.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private RequestRepository requestRepo;
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String home() {
		return "admin/home";
	}
	
	@GetMapping("/appointment_details")
	public String home4(Model m)
	{
		List<Appointments> list =	appointmentRepo.findAll();
		m.addAttribute("appointmentlist",list); 	
		return "admin/appointment_details";
	}
	
	@GetMapping("/appointment_add")
	public String loadForm1()
	{
		
		return "admin/appointment_add";
	}
	
	@PostMapping("/save_appointments")
	public String saveProducts(@ModelAttribute Appointments appointments, HttpSession session) {

		appointmentRepo.save(appointments);
		session.setAttribute("msg", "Appointment Added Sucessfully..");

		return "redirect:/admin/appointment_details";
	}
	
	
	
	
	
	@GetMapping("/request_details")
	public String home3(Model m)
	{
		
	  List<Requests> list =	requestRepo.findByStatus();
		m.addAttribute("requestlist",list); 	
		return "admin/request_details";
	}
	
	@GetMapping("/request_status")
	public String home5(Model m)
	{
	  List<Requests> list =	requestRepo.findAll();
		m.addAttribute("requestlist1",list); 	
		return "admin/request_status";
	}

	
	
	
	@GetMapping("/approve_form/{id}")
	public String editForm(@PathVariable(value = "id") int id, Model m) {

		Optional<Requests> request = requestRepo.findById(id);

		Requests res = request.get();
		m.addAttribute("request", res);

		return "admin/request_approved";
	}
	
	@GetMapping("/decline_form/{id}")
	public String editForm2(@PathVariable(value = "id") int id, Model m) {

		Optional<Requests> request = requestRepo.findById(id);

		Requests res = request.get();
		m.addAttribute("request", res);

		return "admin/request_declined";
	}
	
	@PostMapping("/approve_requests")
	public String updateProducts(@ModelAttribute Requests requests, HttpSession session) {

		requestRepo.save(requests);
		session.setAttribute("msg", "Request Approve Sucessfully..");
		
		return "redirect:/admin/request_details";
	}
	
	@PostMapping("/decline_requests")
	public String updateProducts2(@ModelAttribute Requests requests, HttpSession session) {

		requestRepo.save(requests);
		session.setAttribute("msg", "Request Decline Sucessfully..");

		return "redirect:/admin/request_details";
	}
	
	
	@GetMapping("/stock_details")
	public String home2(Model m)
	{
	  List<Blood> list =	stockRepo.findAll();
		m.addAttribute("stocklist",list); 	
		return "admin/stock_details";
	}
	
	
	@GetMapping("/user_details")
	public String home(Model m)
	{
	  List<User> list =	userRepo.findAll();
		m.addAttribute("all_users",list); 	
		return "admin/user_details";
	}
	
	
}
