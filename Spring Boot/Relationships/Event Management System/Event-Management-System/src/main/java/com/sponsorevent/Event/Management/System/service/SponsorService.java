package com.sponsorevent.Event.Management.System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sponsorevent.Event.Management.System.model.Event;
import com.sponsorevent.Event.Management.System.model.Sponsor;
import com.sponsorevent.Event.Management.System.repository.EventRepository;
import com.sponsorevent.Event.Management.System.repository.SponsorRepository;

@Service
public class SponsorService {

	@Autowired
	private SponsorRepository sponsorrepository;
	
	@Autowired
	private EventRepository  eventrepository;
	
	public List<Sponsor> getsponsors(){
		return sponsorrepository.findAll();
	}
	
	public Sponsor getsponsor(int sponsorid) {
		return sponsorrepository.findById(sponsorid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Sponsor addsponsor(Sponsor sponsor) {
		try {
			List<Integer> eventids =new ArrayList<>();
			for(Event event : sponsor.getEvents()) {
				eventids.add(event.getEventid());
			}
			
			List<Event> completeevents = eventrepository.findAllById(eventids);
			if(eventids.size()!=completeevents.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more event ids are invalid");
			}
			
			
			for(Event e : completeevents) {
				e.getSponsors().add(sponsor);
			}
			sponsor.setEvents(completeevents);
			return sponsorrepository.save(sponsor);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"wrong events");
		}
}
	
	public Sponsor updatesponsor(int sponsorid , Sponsor updatedsponsor) {
		try {
			Sponsor existingsponsor = sponsorrepository.findById(sponsorid).get();
			List<Integer> eventids = new ArrayList<>();
			for(Event event: updatedsponsor.getEvents()) {
				eventids.add(event.getEventid());
			}
			List<Event> completeevents = eventrepository.findAllById(eventids);
			if(eventids.size()!=completeevents.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more event ids are invalid");
			}
			for(Event e : completeevents) {
				e.getSponsors().add(existingsponsor);
			}
			
			existingsponsor.setSponsorname(updatedsponsor.getSponsorname());
			existingsponsor.setIndustry(updatedsponsor.getIndustry());
			existingsponsor.setEvents(completeevents);
			
			
			return sponsorrepository.save(existingsponsor);
		} catch (Exception e) {
			throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	public void deletesponsor(int sponsorid) {
		Sponsor sponsor = sponsorrepository.findById(sponsorid).get();
		List<Event> events = sponsor.getEvents();
		for(Event event:events) {
			event.getSponsors().remove(sponsor);
		}
		eventrepository.saveAll(events);
		sponsorrepository.deleteById(sponsorid);
		
	}
}
