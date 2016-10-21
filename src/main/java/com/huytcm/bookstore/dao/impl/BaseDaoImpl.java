package com.huytcm.bookstore.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.huytcm.bookstore.dao.IBaseDao;

@Repository
public class BaseDaoImpl <Model, Id> implements IBaseDao<Model, Id> {
	private Class<Model> clazz;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseDaoImpl(Class<Model> clazz) {
		super();
		this.clazz = clazz;
	}
	
	public void setClazz(Class<Model> clazz) {
		this.clazz = clazz;
	}
	
	protected Session getSession() {
		if (sessionFactory == null) {
			sessionFactory = (SessionFactory) new LocalSessionFactoryBean();
		}
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Model getById(Id id) {
		return (Model) getSession().get(clazz, (Serializable) id);
	}

	@Override
	public void insert(Model model) {
		getSession().save(model);
	}

	@Override
	public void update(Model model) {
		getSession().update(model);
	}

	@Override
	public void delete(Model model) {
		getSession().delete(model);
	}

	@Override
	public List<Model> getAll() {
		String sql = "select e from " + clazz.getSimpleName() + " e";
        Query query = getSession().createQuery(sql);
        @SuppressWarnings("unchecked")
		List<Model> list = (List<Model>)query.list();
        return list;
	}
	
	@SuppressWarnings("unused")
	private static SessionFactory buildSessionFactory() {
        // Create Configuration
        Configuration configuration = new Configuration();
 
        // By default, Hibernate will read hibernate.cfg.xml configuration file
        // You can specify the file if you want:
        // configuration.configure("myhiberante.cfg.xml");
        configuration.configure();
 
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
 
        // Create SessionFactory
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
