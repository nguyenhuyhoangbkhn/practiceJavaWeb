package com.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ApplicantDAO;
import com.entity.Applicant;
import com.model.ApplicantInfo;

public class ApplicantDAOImpl implements ApplicantDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<ApplicantInfo> listApplicantInfos() {
		String sql = "Select new " + ApplicantInfo.class.getName()//
				+ "(a.id, a.name, a.email, a.gender, a.position, a.company) "//
				+ " from " + Applicant.class.getName() + " a ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}

	public Applicant findApplicant(String id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Applicant.class);
		crit.add(Restrictions.eq("id", id));
		return (Applicant) crit.uniqueResult();
	}

	public ApplicantInfo findApplicantInfo(String id) {
		Applicant applicant = this.findApplicant(id);
		if (applicant == null) {
			return null;
		}
		return new ApplicantInfo(applicant.getId(), applicant.getName(), applicant.getEmail(), applicant.getGender(),
				applicant.getPosition(), applicant.getCompany());
	}

	@Override
	public void saveApplicant(ApplicantInfo applicantInfo) {
		Applicant applicant = new Applicant();
		applicant.setId(applicantInfo.getId());
		applicant.setEmail(applicantInfo.getEmail());
		applicant.setGender(applicantInfo.getGender());
		applicant.setName(applicantInfo.getName());
		applicant.setPosition(applicantInfo.getPosition());
		applicant.setCompany(applicantInfo.getCompany());

		Session session = this.sessionFactory.getCurrentSession();
		session.save(applicant);

	}

	@Override
	public void deleteApplicant(String id) {
		// TODO Auto-generated method stub
		Applicant applicant = this.findApplicant(id);
		if (applicant != null) {
			this.sessionFactory.getCurrentSession().delete(applicant);
		}

	}

	@Override
	public void addStaff(ApplicantInfo applicantInfo) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(applicantInfo);
	}

	@Override
	public void updateApplicantInfo(ApplicantInfo applicantInfo) {
		// TODO Auto-generated method stub
		System.out.println("id"+ applicantInfo.getId());

		String id = applicantInfo.getId();
		Applicant applicant =  this.findApplicant(id);
		// Applicant applicant = new Applicant();
		// applicant.setId(applicantInfo.getId());
		applicant.setEmail(applicantInfo.getEmail());
		applicant.setGender(applicantInfo.getGender());
		applicant.setName(applicantInfo.getName());
		applicant.setPosition(applicantInfo.getPosition());
		applicant.setCompany(applicantInfo.getCompany());

		Session session = this.sessionFactory.getCurrentSession();
		session.update(applicant);
	}

}
