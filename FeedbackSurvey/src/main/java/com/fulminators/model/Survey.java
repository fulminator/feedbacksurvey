package com.fulminators.model;

import java.util.List;

public class Survey implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// private variables ***
	// SurveyId - unique identifier of a survey
	private int surveyId;
	// Title - survey name (Java course)
	private String title;
	// Description - small summary of the survey
	private String description;
	// questions of the survey @Transient
	private List<String> question;
	// answers of the survey @Transient
	private List<String> answer;

	// getters and setters ***
	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getQuestion() {
		return question;
	}

	public void setQuestion(List<String> question) {
		this.question = question;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("Id : ").append(this.getSurveyId());
        strBuff.append(", Title : ").append(this.getTitle());
        strBuff.append(", Description : ").append(this.getDescription());
		return strBuff.toString();
	}
}
