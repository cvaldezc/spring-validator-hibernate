package io.cvaldezchavez.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.cvaldezchavez.form.Subcriptor;

@Repository
@Transactional
public class SubcriptorDaoImpl implements SubcriptorDao {

	// @Resource(name = "sessionFactory")
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Subcriptor saveSubcriptor(Subcriptor subcriptor) {
		getCurrentSession().save(subcriptor);
		return subcriptor;
	}

	@Override
	public List<Subcriptor> listSubcriptor() {
		return getCurrentSession().createQuery("from Subcriptor").list();
	}

}
