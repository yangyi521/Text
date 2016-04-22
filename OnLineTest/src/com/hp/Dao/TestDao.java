package com.hp.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hp.bean.Subject;
import com.hp.util.HibernateSessionFactory;

public class TestDao {
  public List<Subject> randomFindSubject(int number){
	  List list = null;
	  Session session = HibernateSessionFactory.getSession();
	  session.beginTransaction();
	  Query query = session.createQuery("from Subject as sub order by rand()");
	  query.setMaxResults(number);
	  list = query.list();
	  session.getTransaction().commit();
	  HibernateSessionFactory.closeSession();
	  return list;
  }
}
