package com.marketingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;
	//Using Microservice with Project searchmarketinglead1
	//CRUD Operaton API to be developed
	//http://localhost:8090/api/leads
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
		
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		
		leadRepo.save(lead);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);

	}
	
	@DeleteMapping("/{id}")
	public void deleteOneLead(@PathVariable("id") long id ) {
		leadRepo.deleteById(id);

	}
		//localhost:8090/api/leads/7

	@GetMapping("/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
		
	
	
	}
	//using Microservices searchmarketingapp project
	//http://localhost:8090/api/leads/lead/6
	//how to consume API in your project in webServices
	@GetMapping("/lead/{id}")
	public Lead getOneLead(@PathVariable("id") Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}
