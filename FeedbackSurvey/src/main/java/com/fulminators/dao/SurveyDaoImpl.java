package com.fulminators.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.fulminators.model.Survey;
import com.fulminators.util.HibernateUtil;

public class SurveyDaoImpl implements SurveyDao {

	private Transaction trns = null;
	private Session session = HibernateUtil.getSessionFactory()
			.getCurrentSession();

	@Override
	public Survey getBySurveyID(int surveyID) {
		System.out.println("Trying to get survey ID " + surveyID);
		Survey survey = null;
		try {
			survey = (Survey) session.get(Survey.class, surveyID);
		} catch (Exception e) {
			System.err.println("Error! Survey not fetched!");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		System.out.println("Returned survey ID " + surveyID);
		return survey;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> getAllSurvey() {
		Criteria criteria = session.createCriteria(Survey.class);
		criteria.addOrder(Order.asc("surveyid"));
		System.out.println("Returned all surveys!");
		return criteria.list();
	}

	@Override
	public void save(Survey survey) {
		try {
			trns = session.beginTransaction();
			session.save(survey);
			session.getTransaction().commit();
			System.out.println("Survey saved!");
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			System.err.println("Error! Survey not saved!");
			e.printStackTrace();
		} finally {	
			if (session != null && session.isOpen()) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public void update(Survey survey) {
		try {
			trns = session.beginTransaction();
			session.update(survey);
			session.getTransaction().commit();
			System.out.println("Survey updated!");
		} catch (Exception e) {
			if (trns != null) {
				trns.rollback();
			}
			System.err.println("Error! Survey not updated!");
			e.printStackTrace();
		} finally {			
			if (session != null && session.isOpen()) {
				session.flush();
				session.close();
			}
		}

	}

	@Override
	public void view(Survey survey) {
		update(survey);
	}

	@Override
	public void delete(int surveyID) {
		System.out.println("Trying to get survey ID " + surveyID);
		Survey survey = null;
		try {
			survey = (Survey) session.get(Survey.class, surveyID);
			session.delete(survey);
			System.out.println("Deleted survey ID " + surveyID);
		} catch (Exception e) {
			System.err.println("Error! Survey not deleted!");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
