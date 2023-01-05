package com.product.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.product.entity.Product;

public class HibernateUtility {
public static  SessionFactory getsessionFactory() {
	Configuration configuration= new Configuration();
	configuration.configure().addAnnotatedClass(Product.class);
	SessionFactory sessionFactory =configuration.buildSessionFactory();
	
	return sessionFactory;
	
}
}