package com.fulminators.dao;

import java.util.List;

import com.fulminators.model.Survey;

public interface SurveyDao {
	
	Survey getBySurveyID(int surveyID);

	List<Survey> getAllSurvey();

	void save(Survey survey);

	void update(Survey survey);

	void view(Survey survey);

	void delete(int surveyID);
}
