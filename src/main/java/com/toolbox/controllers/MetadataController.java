package com.toolbox.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toolbox.model.Metadata;
import com.toolbox.repositories.MetadataRepository;

/**
 * This is a controller to perform operations on Metadata Document
 * 
 * @author faisal
 *
 */

@RestController
public class MetadataController {

	@Autowired
	MetadataRepository metadataRepository;

	private static final Logger log = LoggerFactory.getLogger(MetadataController.class);

	@PostMapping("/metadata/add")
	public Metadata addMetadata(@RequestBody Metadata metadata) {
		System.out.println("Hello"+metadata.toString());
		log.info("Adding Metadata to ES:", metadata.toString());
		return metadataRepository.save(metadata);
	}
	@PostMapping("/metadata/addBulk")
	public Iterable<Metadata> addBulkMetadata(@RequestBody List<Metadata> metadataList) {
			log.info("Adding Metadata to ES:", metadataList.toString());
			return metadataRepository.saveAll(metadataList);
	}
	
	
	@GetMapping("/metadata/all")
	public List<Metadata> getMetadata() {
		Iterator<Metadata> iterator = metadataRepository.findAll().iterator();
		List<Metadata> metadatas = new ArrayList<>();
		while (iterator.hasNext()) {
			metadatas.add(iterator.next());
		}
		return metadatas;
	}

	@GetMapping("/metadata/{id}")
	public Optional<Metadata> getMetadata(@PathVariable Integer id) {
		return metadataRepository.findById(id);
	}

	@PutMapping("/metadata/{id}")
	public Metadata updateMetadata(@PathVariable Integer id, @RequestBody Metadata metadata) {
		Optional<Metadata> std = metadataRepository.findById(id);
		if (std.isPresent()) {
			Metadata s = std.get();
			s.setVolumeTitle(metadata.getVolumeTitle());
			return metadataRepository.save(s);
		} else {
			return null;

		}
	}

	@DeleteMapping("/metadata/{id}")
	public String deleteMetadata(@PathVariable Integer id) {
		metadataRepository.deleteById(id);
		return "Metadata Deleted";
	}
}
