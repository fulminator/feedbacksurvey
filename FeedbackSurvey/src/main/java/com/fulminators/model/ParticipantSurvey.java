package com.fulminators.model;

import java.io.Serializable;

public class ParticipantSurvey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ParticipantID - reference to a participant
	private int participantID;
	// SurveyID - reference to a survey
	private int surveyID;
	
	public int getParticipantID() {
		return participantID;
	}
	public void setParticipantID(int participantID) {
		this.participantID = participantID;
	}
	public int getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}
	
	
}
