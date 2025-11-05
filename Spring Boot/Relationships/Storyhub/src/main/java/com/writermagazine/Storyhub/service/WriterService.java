package com.writermagazine.Storyhub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.writermagazine.Storyhub.model.Magazine;
import com.writermagazine.Storyhub.model.Writer;
import com.writermagazine.Storyhub.repository.MagazineRepository;
import com.writermagazine.Storyhub.repository.WriterRepository;

@Service
public class WriterService {

	@Autowired
	private WriterRepository writerrepository;

	@Autowired
	private MagazineRepository magazinerepository;

	public List<Writer> getwriters() {
		return writerrepository.findAll();
	}

	public Writer getwriter(int writerid) {
		try {
			Writer writer = writerrepository.findById(writerid).get();
			return writer;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no writer with id: " + writerid);
		}
	}

	public Writer addwriter(Writer writer) {

		List<Integer> magazineids = new ArrayList<>();
		for (Magazine magazine : writer.getMagazines()) {
			magazineids.add(magazine.getMagazineid());
		}

		List<Magazine> completemagazine = magazinerepository.findAllById(magazineids);
		if (magazineids.size() != completemagazine.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more magazine ids are invalid");
		}
		writer.setMagazines(completemagazine);

		return writerrepository.save(writer);

	}
	
	
	public Writer updatewriter(int writerid,Writer updatedwriter) {
	
			Writer existingwriter = writerrepository.findById(writerid)
					.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no writer with id: "+writerid));
			
			List<Integer> magazineids = new ArrayList<>();
			List<Magazine> magazines = updatedwriter.getMagazines();
			for(Magazine magazine:magazines) {
				magazineids.add(magazine.getMagazineid());
			}
			List<Magazine> completemagazine = magazinerepository.findAllById(magazineids);
			if (magazineids.size() != completemagazine.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more magazine ids are invalid");
			}
			existingwriter.setMagazines(completemagazine);
			existingwriter.setWritername(updatedwriter.getWritername());
			existingwriter.setBio(updatedwriter.getBio());
			
			return writerrepository.save(existingwriter);
		} 
		
	
	public void deletewriter(int writerid) {
		Writer writer = writerrepository.findById(writerid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no writer with id :"+ writerid));
		List<Magazine> magazines = writer.getMagazines();
		for(Magazine magazine : magazines) {
			magazine.getWriters().remove(writer);
		}
		magazinerepository.saveAll(magazines);
		writerrepository.deleteById(writerid);
		
		
		
	}
}
