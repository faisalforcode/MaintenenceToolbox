/**
 * 
 */
package com.toolbox.serviceimpl;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.toolbox.constants.JsonConstants;
import com.toolbox.services.JsonService;

/**
 * 
 * @author faisal
 *
 */
public class JsonServiceImpl implements JsonService {

	private static final Logger log = LoggerFactory.getLogger(JsonServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.toolbox.services.JsonService#parseJson(java.lang.String)
	 */
	@Override
	public String parseJson(String filePath) {
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\faisa\\OneDrive\\Desktop\\ACRepair.json"));

			JSONObject jsonObject = (JSONObject) obj;

			String name = (String) jsonObject.get(JsonConstants.TITLE);
			String volume = (String) jsonObject.get(JsonConstants.VOLUME_NUMBER);
			String volumeType = (String) jsonObject.get(JsonConstants.VOLUME_TYPE);
			String applicability = (String) jsonObject.get(JsonConstants.APPLICABILITY);
			String issuedDate = (String) jsonObject.get(JsonConstants.ISSUE_DATE);
			String contentFileName = (String) jsonObject.get(JsonConstants.CONTENT_FILE_NAME);
			String model = (String) jsonObject.get(JsonConstants.MODEL);

			log.info("Name: ", name);
			log.info("Volume: ", volume);
			log.info("volumeType: ", volumeType);
			log.info("applicability: ", applicability);
			log.info("Issue Date: ", issuedDate);
			log.info("Content File: ", contentFileName);
			log.info("Model: ", model);

		} catch (Exception e) {
			log.error("Exception in Json Parsing", e);
		}
		return "Success";
	}

}
