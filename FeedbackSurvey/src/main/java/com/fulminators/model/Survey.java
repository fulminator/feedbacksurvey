package com.fulminators.model;

import java.util.ArrayList;
import java.util.List;

import com.fulminators.dao.SurveyDao;
import com.fulminators.dao.SurveyDaoImpl;

public class Survey implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// private variables ***
	// SurveyID - unique identifier of a survey
	private int surveyID;
	// Title - survey name (Java course)
	private String title;
	// Description - small summary of the survey
	private String description;
	// questions of the survey @Transient
	private List<String> question;
	// answers of the survey @Transient
	private List<String> answer;

	// default public constructor (JavaBean required) ***
	public Survey() {

	}

	// explicit constructor ***
	public Survey(int surveyID, String title, String description) {
		this.surveyID = surveyID;
		this.title = title;
		this.description = description;
	}

	// getters and setters ***
	public int getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
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

	// some functions accessed from jsf ***
	public void saveSurvey() {
		SurveyDao dao = new SurveyDaoImpl();
		dao.save(this);
		clearAll();
	}

	public void updateSurvey() {	
		SurveyDao dao = new SurveyDaoImpl();
		dao.update(this);
		clearAll();
	}

	public void deleteSurvey() {
		SurveyDao dao = new SurveyDaoImpl();
		dao.delete(surveyID);
		clearAll();
	}

	public List<Survey> getAllSurveys() {
		List<Survey> surveys = new ArrayList<Survey>();
		SurveyDao dao = new SurveyDaoImpl();
		surveys = dao.getAllSurvey();
		return surveys;
	}

/*	public void fullInfo() {
		SurveyDao dao = new SurveyDaoImpl();
		List<Survey> lc = dao.(selectedname);
		System.out.println(lc.get(0).firstName);
		this.custId = lc.get(0).custId;
		this.firstName = lc.get(0).firstName;
		this.lastName = lc.get(0).lastName;
		this.email = lc.get(0).email;
		this.dob = lc.get(0).dob;
		this.sd = sdf.format(dob);
	}*/

	private void clearAll() {
		this.title = "";
		this.description = "";
	}
}
