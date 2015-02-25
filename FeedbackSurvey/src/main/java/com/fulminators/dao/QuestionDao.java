package com.fulminators.dao;

import java.util.List;

import com.fulminators.model.Question;

public interface QuestionDao {

	Question getByQuestionID(int Question_ID);

	List<Question> getAllQuestion();

	void save(Question question);

	void update(Question question);

	void view(Question question);

	void delete(int Question_ID);
}
