package com.sponsorevent.Event.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sponsorevent.Event.Management.System.model.Sponsor;
import com.sponsorevent.Event.Management.System.service.SponsorService;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

	@Autowired
	private SponsorService sponsorservice;
	
	@GetMapping("/getsponsors")
	public List<Sponsor> getsponsors(){
		return sponsorservice.getsponsors();
	}
	
	@GetMapping("/getsponsor/{sponsorid}")
	public Sponsor getsponsor(@PathVariable int sponsorid) {
		return sponsorservice.getsponsor(sponsorid);
	}
	
	@PostMapping("/addsponsor")
	public Sponsor addsponsor(@RequestBody Sponsor sponsor) {
		return sponsorservice.addsponsor(sponsor);
	}
	
	@PutMapping("/updatesponsor/{sponsorid}")
	public Sponsor updatesponsor(@PathVariable int sponsorid,@RequestBody Sponsor sponsor) {
		return sponsorservice.updatesponsor(sponsorid, sponsor);
	}
	
	@DeleteMapping("deletesponsor/{sponsorid}")
	public void deletesponsor(@PathVariable int sponsorid) {
		 sponsorservice.deletesponsor(sponsorid);
	}
}
