package com.toolbox.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Metadata Model Mapped to the incoming JSON in the System
 * 
 * @author Faisal Khan
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "metadata", type = "default")
public class Metadata {
	/*
	 * Primary Key
	 */
	@Id
	private int id;

	/*
	 * Title of the Manual
	 */
	private String volumeTitle;

	/*
	 * The uniquely identifiable number of the manual
	 */
	private String volumeNumber;

	/*
	 * The Type of the manual coming in
	 */
	private String volumeType;

	/*
	 * This defines the applicability of the manual to a particular Airplane Model
	 * 
	 */
	private String applicability;

	/*
	 * The issue date of the Manual
	 */
	private String issuedDate;

	/*
	 * The name of the Media File
	 */
	private String contentFileName;

	/*
	 * Defines the applicability to a particular model of the Aircraft
	 */
	private String model;

	/*
	 * Variant of the applicable model
	 */
	private String variant;
}
