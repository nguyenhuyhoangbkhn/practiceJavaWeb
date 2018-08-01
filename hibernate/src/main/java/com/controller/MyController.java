package com.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rikkeisoft.com.dao.ApplicantDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.ApplicantInfo;

@SuppressWarnings("unused")
@Controller
// Cần thiết cho Hibernate Transaction.
@Transactional
// Cần thiết để sử dụng RedirectAttributes
@EnableWebMvc
public class MyController {

	@Autowired
	private ApplicantDAO applicantDAO;

	@RequestMapping("/")
	public String homePage(Model model) {

		return applicantList(model);
	}

	@RequestMapping("/list")
	public String applicantList(Model model) {
		List<ApplicantInfo> list = applicantDAO.listApplicantInfos();
		model.addAttribute("applicantInfos", list);
		return "list";
	}

	@RequestMapping("/deleteApplicant")
	public String deleteApplicant(Model model, @RequestParam("id") String id) {
		if (id != null) {
			this.applicantDAO.deleteApplicant(id);
		}
		return "redirect:/list";
	}

	@RequestMapping("/form")
	public ModelAndView form(Model model) {
		return new ModelAndView("form", "command", new ApplicantInfo());
	}

	@RequestMapping(value = "/addstaff", method = RequestMethod.POST)
	public String add(Model model,@ModelAttribute("addform") @Validated ApplicantInfo applicantInfo,BindingResult result){
//		System.out.println("demo 123"+applicantInfo+"end");
		this.applicantDAO.saveApplicant(applicantInfo);
		return "redirect:/list";
	}
	
	@RequestMapping("/edit")
	public String editApplicant(Model model, @RequestParam("id") String id) {
		if (id != null) {
			ApplicantInfo applicantInfo = new ApplicantInfo();
			applicantInfo = this.applicantDAO.findApplicantInfo(id);		
			model.addAttribute("applicantInfo", applicantInfo);
			return "formedit";
		}
		return "redirect:/list";
	}
	@RequestMapping(value = "/editStaff", method = RequestMethod.POST)
	public String editStaff(@ModelAttribute("applicantInfo") ApplicantInfo ApplicantInfo) {
		System.out.println("demo hoangnh" + ApplicantInfo + "edit staff end");
		this.applicantDAO.updateApplicantInfo(ApplicantInfo);
		return "redirect:/list";
	}
}