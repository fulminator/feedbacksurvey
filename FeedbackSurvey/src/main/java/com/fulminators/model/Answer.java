package com.fulminators.model;

import java.io.Serializable;

public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private variables	***
	// AnswerID - unique identifier of an answer (it is unique to a question)
	private int answerID;
	// QuestionID - reference to a question
	private int questionID;
	// ParticipantID - reference to a participant
	private int participantID;	//	ignored for now
	// ChoiceText - free text for an answer
	private String choiceText;	//	ignored for now
	// content of answer - temporary until choiceText will be implemented
	private String answer;
	
	// default constructor (javaBean requierement)	***
	public Answer() {
	
	}
	
	// explicit constructor	***
	public Answer(int answerID, int questionID, String answer) {
		this.answerID = answerID;
		this.questionID = questionID;
		this.answer = answer;
	}
	
	// getters and setters	***
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getAnswerID() {
		return answerID;
	}
	
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	
	public int getQuestionID() {
		return questionID;
	}
	
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	
	public int getParticipantID() {
		return participantID;
	}
	
	public void setParticipantID(int participantID) {
		this.participantID = participantID;
	}
	
	public String getChoiceText() {
		return choiceText;
	}
	
	public void setChoiceText(String choiceText) {
		this.choiceText = choiceText;
	}
	
	
}
