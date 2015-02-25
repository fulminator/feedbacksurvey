package com.fulminators.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.fulminators.model.Answer;
import com.fulminators.util.HibernateUtil;

public class AnswerDaoImpl implements AnswerDao {

	private Transaction trns = null;
	private Session session = HibernateUtil.getSessionFactory()
			.getCurrentSession();

	@Override
	public Answer getByAnswerID(int answerID) {
		System.out.println("Trying to get question ID " + answerID);
		Answer answer = null;
		try {
			answer = (Answer) session.get(Answer.class, answerID);
		} catch (Exception e) {
			System.err.println("Error! Answer not fetched!");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		System.out.println("Returned survey ID " + answerID);
		return answer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> getAllQuestion() {
		Criteria criteria = session.createCriteria(Answer.class);
		criteria.addOrder(Order.asc("answerid"));
		System.out.println("Returned all answers!");
		return criteria.list();
	}

	@Override
	public void save(Answer answer) {
		try {
			trns = session.beginTransaction();
			session.save(answer);
			session.getTransaction().commit();
			System.out.println("Answer saved!");
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			System.err.println("Error! Answer not saved!");
			e.printStackTrace();
		} finally {
			session.flush();
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void update(Answer answer) {
		try {
			trns = session.beginTransaction();
			session.update(answer);
			session.getTransaction().commit();
			System.out.println("Answer updated!");
		} catch (Exception e) {
			if (trns != null) {
				trns.rollback();
			}
			System.err.println("Error! Answer not updated!");
			e.printStackTrace();
		} finally {
			session.flush();
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void view(Answer answer) {
		update(answer);
	}

	@Override
	public void delete(int answerID) {
		System.out.println("Trying to get question ID " + answerID);
		Answer answer = null;
		try {
			answer = (Answer) session.get(Answer.class, answerID);
			session.delete(answer);
			System.out.println("Deleted answer ID " + answerID);
		} catch (Exception e) {
			System.err.println("Error! Answer not deleted!");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
