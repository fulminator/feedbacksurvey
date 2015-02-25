package com.fulminators.model;

import java.io.Serializable;

public class Choice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ChoiceID - unique identifier of a choice
	private int choiceID;
	// QuestionID - reference to a question
	private int questionID;
	// Choice - text describing the choice
	private String choice;
	
	public int getChoiceID() {
		return choiceID;
	}
	public void setChoiceID(int choiceID) {
		this.choiceID = choiceID;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	
}
