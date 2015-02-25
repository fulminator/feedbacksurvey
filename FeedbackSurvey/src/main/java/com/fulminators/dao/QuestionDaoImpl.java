package com.fulminators.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.fulminators.model.Question;
import com.fulminators.util.HibernateUtil;

public class QuestionDaoImpl implements QuestionDao {

	private Transaction trns = null;
	private Session session = HibernateUtil.getSessionFactory()
			.getCurrentSession();

	@Override
	public Question getByQuestionID(int questionID) {
		System.out.println("Trying to get question ID " + questionID);
		Question question = null;
		try {
			question = (Question) session.get(Question.class, questionID);
		} catch (Exception e) {
			System.err.println("Error! Question not fetched!");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		System.out.println("Returned survey ID " + questionID);
		return question;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAllQuestion() {
		Criteria criteria = session.createCriteria(Question.class);
		criteria.addOrder(Order.asc("questionid"));
		System.out.println("Returned all questions!");
		return criteria.list();
	}

	@Override
	public void save(Question question) {
		try {
			trns = session.beginTransaction();
			session.save(question);
			session.getTransaction().commit();
			System.out.println("Question saved!");
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			System.err.println("Error! Question not saved!");
			e.printStackTrace();
		} finally {
			session.flush();
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void update(Question question) {
		try {
			trns = session.beginTransaction();
			session.update(question);
			session.getTransaction().commit();
			System.out.println("Question updated!");
		} catch (Exception e) {
			if (trns != null) {
				trns.rollback();
			}
			System.err.println("Error! Question not updated!");
			e.printStackTrace();
		} finally {
			session.flush();
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void view(Question question) {
		update(question);
	}

	@Override
	public void delete(int questionID) {
		System.out.println("Trying to get question ID " + questionID);
		Question question = null;
		try {
			question = (Question) session.get(Question.class, questionID);
			session.delete(question);
			System.out.println("Deleted question ID " + questionID);
		} catch (Exception e) {
			System.err.println("Error! Question not deleted!");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
