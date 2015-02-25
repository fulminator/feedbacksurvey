package com.fulminators.dao;

import java.util.List;

import com.fulminators.model.Answer;

public interface AnswerDao {

	Answer getByAnswerID(int answerID);

	List<Answer> getAllQuestion();

	void save(Answer answer);

	void update(Answer answer);

	void view(Answer answer);

	void delete(int answerID);
}
