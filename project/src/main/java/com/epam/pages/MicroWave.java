package com.epam.pages;

public class MicroWave {
	
	protected String commonName;
	protected String firstName;
	protected String secondName;
	
	public MicroWave withCommonName(String commonName) {
		this.commonName = commonName;
		return this;
	}
	public MicroWave withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public MicroWave withSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}
	
	

}
