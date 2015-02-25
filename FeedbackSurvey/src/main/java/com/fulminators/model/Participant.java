package com.fulminators.model;

import java.io.Serializable;

public class Participant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ParticipantID - unique identifier of a participant
	private int participantID;
	// Name - text - the name of the one taking the survey
	private String name;
	// Email
	private String email;
	
	public int getParticipantID() {
		return participantID;
	}
	public void setParticipantID(int participantID) {
		this.participantID = participantID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
