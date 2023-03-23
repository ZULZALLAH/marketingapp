package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.util.EmailService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService; 
	//http://localhost:8080/viewCreateLead
	@RequestMapping("/viewCreateLead")
	public String viewCreateLeadForm() {
		return "create_registration";
		
	}
	//@RequestMapping("/saveLead")
	//public String saveOneLead(Lead lead) {
		
		//System.out.println(lead.getFirstName());
		//System.out.println(lead.getLastName());
		//System.out.println(lead.getEmail());
		//System.out.println(lead.getMobile());
					//OR
//	public String saveOneLead(@RequestParam("firstName") String fame,@RequestParam("lastName") String lastname,@RequestParam("email") String email,@RequestParam("mobile") long mobile) {
//		
//		Lead l = new Lead();
//		l.setFirstName(fame);
//		l.setLastName(lastname);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		leadService.saveLead(l);
//		return "create_registration";
//		
//		
//	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@ModelAttribute("lead")Lead lead,ModelMap model) {
//		leadService.saveLead(lead);
//		model.addAttribute("msg","record is saved!");
//		//System.out.println(100);
//
//		return "create_registration";
//		
//}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(LeadDto leadDto,ModelMap model) {
		
		Lead l = new Lead();
		l.setFirstName(leadDto.getFirstName());
		l.setLastName(leadDto.getLastName());
		l.setEmail(leadDto.getEmail());
		l.setMobile(leadDto.getMobile());
		model.addAttribute("msg","record is saved!");
		emailService.sendEmail(leadDto.getEmail(), "Test", "Welcome");
		
	    leadService.saveLead(l);
		//System.out.println(100);

		return "create_registration";
		
}
	//localhost:8080/listleads
	@RequestMapping("/listleads")
	public String getAllLeads(ModelMap model) {
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads",leads);
		
		return "list_leads";
		
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id,ModelMap model) {
		System.out.println(id);
		leadService.deleteLead(id);
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads",leads);
		return "list_leads";
		
	}
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
		
	}
	
	@RequestMapping(value ="/updateLead",method = RequestMethod.POST)
	public String updateOneLead(@ModelAttribute("lead")Lead lead,ModelMap model) {
		leadService.saveLead(lead);
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads",leads);
		return "list_leads";
		
	}
	
	

}
