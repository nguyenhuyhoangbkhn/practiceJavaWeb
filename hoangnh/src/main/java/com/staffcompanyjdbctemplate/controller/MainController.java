package com.staffcompanyjdbctemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.staffcompanyjdbctemplate.dao.StaffDao;
import com.staffcompanyjdbctemplate.model.Staff;

@SuppressWarnings("unused")
@Controller
public class MainController {

	@Autowired
	private StaffDao staffDao;

	// test request
	@RequestMapping("/test")
	public String homePage(Model model) {
		return "test";
	}

	// @RequestMapping("/index")
	// public String test(Model model) {
	// @SuppressWarnings("resource")
	// ClassPathXmlApplicationContext ctx = new
	// ClassPathXmlApplicationContext("spring.xml");
	//
	// StaffDao staffDao = ctx.getBean("staffDao", StaffDao.class);
	//
	// List<Staff> staffList = staffDao.getAllStaff();
	// model.addAttribute("list", staffList);
	//
	// return "index";
	// }

	@RequestMapping("/form")
	public ModelAndView form(Model model) {
		return new ModelAndView("form", "command", new Staff());
	}

	@RequestMapping(value = "/addstaff", method = RequestMethod.POST)
	public String add(@ModelAttribute("staff") Staff staff) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		StaffDao staffDao = ctx.getBean("staffDao", StaffDao.class);
		System.out.println("demo" + staff);
		staffDao.addStaff(staff);
		return "redirect:/index?company=all";
	}

	@RequestMapping("/delete")
	public String delete(Model model, @RequestParam("custid") int custId) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		StaffDao staffdao = context.getBean(StaffDao.class);
		if (custId >= 0) {
			System.out.println("demo" + custId);
			staffdao.deleteStaff(custId);
		}
		return "redirect:/index?company=all";
	}

	@RequestMapping("/edit")
	public String edit(Model model, @RequestParam("custid") int custId) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		StaffDao staffdao = context.getBean(StaffDao.class);
		Staff staff = null;
		staff = staffdao.findByStaffId(custId);
		System.out.println("demo" + staff);
		model.addAttribute("staff", staff);
		return "formedit";
	}

	@RequestMapping(value = "/editstaff", method = RequestMethod.POST)
	public String editStaff(@ModelAttribute("staff") Staff staff) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		StaffDao staffDao = ctx.getBean("staffDao", StaffDao.class);
		System.out.println("demo" + staff);
		staffDao.updateStaff(staff);
		return "redirect:/index?company=all";
	}

	// @RequestMapping("/index")
	// public String findCompany(Model model, @RequestParam("company") String
	// company) {
	// @SuppressWarnings("resource")
	// ClassPathXmlApplicationContext context = new
	// ClassPathXmlApplicationContext("spring.xml");
	// StaffDao staffdao = context.getBean(StaffDao.class);
	// if(company.equals("all")){
	// List<Staff> staffList = staffDao.getAllStaff();
	// model.addAttribute("list", staffList);
	// } else{
	// List<Staff> staffList = staffDao.getAllStaff();
	// model.addAttribute("list",staffList);
	// }
	// return "index";
	// }

	@RequestMapping("/index")
	public String findCompany(Model model, @RequestParam("company") String company) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		StaffDao staffDao = ctx.getBean("staffDao", StaffDao.class);

		System.out.println("demo" + company);
		if (company.equals("all")) {
			List<Staff> staffList = staffDao.getAllStaff();
			model.addAttribute("list", staffList);
		} else {
			List<Staff> staffList = staffDao.getStaffByNameCompany(company);
			model.addAttribute("list", staffList);
		}
		return "index";

	}
}
