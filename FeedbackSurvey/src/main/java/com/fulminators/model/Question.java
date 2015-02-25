package com.fulminators.model;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// private variables 	***
	// QuestionID - unique identified of a question
	private int questionID;
	// SurveyID - reference to a survey
	private int surveyID;
	// Question - text containing the question
	private String question;
	// ChoiceType - {false - single choice, true - multiple choices}
	private boolean choiceMultiple;
	// answer to question @Transient
	private List<String> answers; 
	
	// default constructor (javaBean requirement)	***
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	// explicit constructor	***
	public Question(int questionID, int surveyID, String question, boolean choiceMultiple) {
		this.questionID = questionID;
		this.surveyID = surveyID;
		this.question = question;
		this.choiceMultiple = choiceMultiple;
	}
	
	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	
	public int getSurveyID() {
		return surveyID;
	}
	
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public boolean isChoiceMultiple() {
		return choiceMultiple;
	}
	
	public void setChoiceMultiple(boolean choiceMultiple) {
		this.choiceMultiple = choiceMultiple;
	}
	
	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}
