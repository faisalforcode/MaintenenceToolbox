package com.toolbox.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolbox.utilities.UnzipUtility;

/**
 * 
 * @author Faisal Khan http://github.com/faisalforcode
 *
 */
@RestController
public class LoadDocumentController {

	@Value(value = "toolbox.extraction.path")
	String destDirectory;

	
	private static final Logger log = LoggerFactory.getLogger(LoadDocumentController.class);

	@PutMapping("/loadDocument/{filePath}")
	public String loadDocument(@PathVariable String filePath) {
		UnzipUtility unzipUtility = new UnzipUtility();
		try {
			unzipUtility.unzip(filePath, destDirectory);
		} catch (IOException e) {
			log.error("Error in Load Document", e);
		}
		return null;
	}
}
