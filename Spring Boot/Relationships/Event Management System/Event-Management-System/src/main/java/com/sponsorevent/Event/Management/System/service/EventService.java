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
public class EventService {

	@Autowired
	private EventRepository eventrepository;
	
	@Autowired
	private SponsorRepository sponsorrepository;
	
	public List<Event> getevents(){
		return eventrepository.findAll();
	}
	
	public Event getevent(int eventid) {
		return eventrepository.findById(eventid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"there is no event with id: "+eventid));
	}
	
	public Event addevent(Event event) {
		try {
			List<Integer> sponsorids = new ArrayList<>();
			for(Sponsor sponsor: event.getSponsors()) {
				sponsorids.add(sponsor.getSponsorid());
			}
			List<Sponsor> completesponsors = sponsorrepository.findAllById(sponsorids);
			if(sponsorids.size()!=completesponsors.size()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"One or more sponsor ids are invalid");
			}
			event.setSponsors(completesponsors);
			for(Sponsor s : completesponsors) {
				s.getEvents().add(event);
			}
			
			return eventrepository.save(event);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"wrong sponsors");
		}
	}
	
	
	public Event updateevent(int eventid, Event updatedevent) {
		try {
			Event existingevent = eventrepository.findById(eventid).get();
			
			List<Integer> sponsorids = new ArrayList<>();
			for(Sponsor sponsor:updatedevent.getSponsors()) {
				sponsorids.add(sponsor.getSponsorid());
			}
			List<Sponsor> completesponsors = sponsorrepository.findAllById(sponsorids);
			if(sponsorids.size()!=completesponsors.size()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"One or more sponsor ids are invalid");
			}
			for(Sponsor s: completesponsors) {
				s.getEvents().add(updatedevent);
			}
			existingevent.setSponsors(completesponsors);
			existingevent.setEventname(updatedevent.getEventname());
			existingevent.setDate(updatedevent.getDate());
			
			return eventrepository.save(existingevent);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"wrong sponsor");
		}
		
		}
	
	public void deleteevent(int eventid) {
		Event event = eventrepository.findById(eventid).get();
		List<Sponsor> sponsors = event.getSponsors();
		for(Sponsor sponsor:sponsors) {
			sponsor.getEvents().remove(event);
		}
		sponsorrepository.saveAll(sponsors);
		eventrepository.deleteById(eventid);
	}
}
