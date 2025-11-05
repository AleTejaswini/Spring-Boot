package com.writermagazine.Storyhub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.writermagazine.Storyhub.model.Magazine;
import com.writermagazine.Storyhub.model.Writer;
import com.writermagazine.Storyhub.repository.MagazineRepository;
import com.writermagazine.Storyhub.repository.WriterRepository;

@Service
public class MagazineService {

	@Autowired
	private MagazineRepository magazinerepository;

	@Autowired
	private WriterRepository writerrepository;

	public List<Magazine> getmagazines() {
		return magazinerepository.findAll();
	}

	public Magazine getmagazine(int magazineid) {
		try {
			Magazine magazine = magazinerepository.findById(magazineid).get();
			return magazine;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no magazine with id: " + magazineid);
		}
	}

	public Magazine addmagazine(Magazine magazine) {

		List<Integer> writerids = new ArrayList<>();
		for (Writer writer : magazine.getWriters()) {
			writerids.add(writer.getWriterid());
		}
		List<Writer> completewriter = writerrepository.findAllById(writerids);
		if (writerids.size() != completewriter.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more writer ids are invalid");
		}

		magazine.setWriters(completewriter);

		return magazinerepository.save(magazine);

	}

	public Magazine updatemagazine(int magazineid, Magazine updatedmagazine) {

		Magazine existingmagazine = magazinerepository.findById(magazineid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no magazine with id :" + magazineid));
		List<Integer> writerids = new ArrayList<>();

		for (Writer writer : updatedmagazine.getWriters()) {
			writerids.add(writer.getWriterid());
		}

		List<Writer> completewriter = writerrepository.findAllById(writerids);
		if (writerids.size() != completewriter.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more writer ids are invalid");
		}
		existingmagazine.setWriters(completewriter);
		existingmagazine.setMagazinename(updatedmagazine.getMagazinename());
		existingmagazine.setPublicationdate(updatedmagazine.getPublicationdate());

		return magazinerepository.save(existingmagazine);

	}

	public void deletemagazine(int magazineid) {
		Magazine magazine = magazinerepository.findById(magazineid).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no magazine with id: " + magazineid));

		List<Writer> writers = magazine.getWriters();
		for (Writer writer : writers) {
			writer.getMagazines().remove(magazine);
		}

		writerrepository.saveAll(writers);
		magazinerepository.deleteById(magazineid);
	}
}
