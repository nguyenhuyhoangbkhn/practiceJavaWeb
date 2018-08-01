package com.springmvcresource.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcresource.dao.CustomerDAO;
import com.springmvcresource.model.Customer;

@SuppressWarnings("unused")
@Controller
public class MyController {

	@RequestMapping(value = "/staticResourceTest")
	public String staticResource(Model model) {
		return "staticResourceTest";
	}

	@RequestMapping("/hello")
	public String hello(Model model) {

		model.addAttribute("greeting", "Hello Spring MVC");

		return "helloworld";

	}
//
//	@RequestMapping("/list")
//    public String List(Model model){
//    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
//		List cus = customerDAO.listCustomer();
//		model.addAttribute("listStaff",cus);
//		return "list";
//	}
	
	@RequestMapping("/form")
	public ModelAndView form(Model model) {
		return new ModelAndView("form", "command", new Customer());
	}
	
	@RequestMapping(value = "/addCus", method = RequestMethod.POST)
	public String add(@ModelAttribute("customer") Customer customer) {	
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
		customerDAO.insert(customer);
		return "redirect:/list?company=all";	
	}
	
	@RequestMapping("/delete")	
	public String delete(Model model, @RequestParam("custid") int custId) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
		if (custId >= 0) {
			System.out.println("demo"+custId);
			customerDAO.deleteCustomer(custId);
		}
		return "redirect:/list";
	}

	@RequestMapping("/edit")
	public String updateform(Model model, @RequestParam("custid") int custId) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
		Customer customer = null;
//		System.out.println("demo"+custId);
		customer=customerDAO.findByCustomerId(custId);
		System.out.println("demo"+ customer);
		model.addAttribute("customer",customer);
		return "formupdate";
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {	
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
		customerDAO.updateCustomer(customer);
		return "redirect:/list";	
	}
	
	@RequestMapping("/list")
	public String findCompany(Model model, @RequestParam("company") String company) {	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
		if(company.equals("all")){
			List cus = customerDAO.listCustomer();
			model.addAttribute("listStaff",cus);
		} else{
			List cus = customerDAO.findByCompany(company);
			model.addAttribute("listStaff",cus);
		}
		
		return "list";
	}
	
}