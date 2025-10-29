package com.bookpublisher.relationship.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.bookpublisher.relationship.model.Publisher;
import com.bookpublisher.relationship.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherrepository;

	public List<Publisher> getpublishers() {
		List<Publisher> publishers = publisherrepository.findAll();
		ArrayList<Publisher> publisherlist = new ArrayList<>(publishers);
		return publisherlist;
	}

	public Optional<Publisher> getpublisher(int publisherid) {
		try {
			Optional<Publisher> publisher = publisherrepository.findById(publisherid);
			return publisher;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public Publisher addpublisher(Publisher publisher) {
		return publisherrepository.save(publisher);
	}

	public Publisher updatepublisher(int publisherid, Publisher publisher) {
		try {
			Publisher newpublisher = publisherrepository.findById(publisherid).get();
			newpublisher.setPublishername(publisher.getPublishername());
			publisherrepository.save(newpublisher);
			return newpublisher;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public void deletepublisher(int publisherid) {
		publisherrepository.deleteById(publisherid);
	}
}
