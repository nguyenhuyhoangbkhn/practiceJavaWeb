package com.springmvcresource.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcresource.dao.CustomerDAO;
import com.springmvcresource.model.Customer;


@SuppressWarnings("unused")
@Controller
public class test {
//	@RequestMapping("/test")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
//		List customer2 = customerDAO.listCustomer();
//		System.out.println("demo" + customer2);
//		
//		
		Customer cus = new Customer(5, "Hoang Nguyen Huy", 28, "develop", "234567", "Rikkei", 100);
		customerDAO.updateCustomer(cus);
		List customer2 = customerDAO.listCustomer();
		System.out.println("demo" + customer2);
	}
	
}