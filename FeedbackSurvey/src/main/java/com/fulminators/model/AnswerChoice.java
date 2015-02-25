package com.fulminators.model;

import java.io.Serializable;

public class AnswerChoice implements Serializable {

	/**
	 * this is just connection
	 */
	private static final long serialVersionUID = 1L;

	// AnswerID - reference to an answer
	private int answerID;
	// ChoiceID - reference to a choice
	private int choiceID;
	
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public int getChoiceID() {
		return choiceID;
	}
	public void setChoiceID(int choiceID) {
		this.choiceID = choiceID;
	}
	
	
}
