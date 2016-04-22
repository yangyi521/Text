package com.hp.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.hp.bean.Subject;
import com.hp.util.HibernateSessionFactory;
import com.hp.util.Page;
import com.hp.util.PageResult;
import com.hp.util.PageUtil;

public class TeacherDao {
//查找试题
	public Subject findSubjectBytitle(String SubjectTilte){
		Subject subject = null;
		List list = new ArrayList();
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		list = session.createQuery("from Subject where SubjectTitle=:subjecttitle")
		.setString("subjecttitle", SubjectTilte).list();
		session.getTransaction().commit();//提交Session
		 HibernateSessionFactory.closeSession();//关闭session
		if(list.size()>0){
			subject = (Subject)list.get(0);
		}
		return subject;
	}
//添加试题
	
	
	public void addSubject(Subject subject){
	  
		 Session session = HibernateSessionFactory.getSession();
		 session.beginTransaction();
		 session.save(subject);
		 session.getTransaction().commit();
		 HibernateSessionFactory.closeSession();

	}
	//根据ID查找试题
	public  Subject findSubjectById(int SubjectId){
		Subject subject = null;
		Session session = HibernateSessionFactory.getSession();
		subject = (Subject) session.get(Subject.class,SubjectId);
		 HibernateSessionFactory.closeSession();
		//ServletActionContext.getRequest().setAttribute("subject", subject);
		 
		 return subject;
	}
	//更新试题
	public void updateSubject(Subject subject){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		//session.update(subject);
		session.update(subject);
		 /*session.createQuery("update Subject set optionA=?, optionB=?, optionC=?, optionD=?, subjectAnswer=?, subjectExplain=?, subjectTitle=? where subjectId=?")
		 .setString(0, subject.getOptionA()).setString(1, subject.getOptionB()).setString(2, subject.getOptionC()).setString(3, subject.getOptionD()).setString(4, subject.getSubjectAnswer())
		 .setString(5, subject.getSubjectExplain()).setString(6, subject.getSubjectTitle()).setLong(7,subject.getSubjectId());*/
		 session.getTransaction().commit();//提交事务
		 HibernateSessionFactory.closeSession();//关闭事务
		
	}
	//删除试题
	public void deleteSubject(int subjectId){
		Session session = HibernateSessionFactory.getSession();
		 Subject subject = (Subject) session.get(Subject.class, subjectId);
		 session.beginTransaction();
		 session.delete(subject);
		 session.getTransaction().commit();//提交事务
		 HibernateSessionFactory.closeSession();//关闭事务
	}
	public List queryall(){
		List list = null;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		list = session.createQuery("from Subject").list();
		session.getTransaction().commit();
		 HibernateSessionFactory.closeSession();
		 return list;}
   //查询所有的试题的方法
	public  PageResult queryall(Page page){
		List list = null;
		TeacherDao teacherdao=new TeacherDao();
		int count=teacherdao.queryall().size();
		
		Session session = HibernateSessionFactory.getSession();//获取session对象
		session.beginTransaction();
		//开启事务
		  page =PageUtil.createPage(page.getEveryPage(),count, page.getCurrentPage());
		
		list = session.createQuery("from Subject").setMaxResults(page.getEveryPage()).setFirstResult(page.getBeginIndex()).list();
		 session.getTransaction().commit();
		// HibernateSessionFactory.closeSession();
		 PageResult result=new PageResult(page,list);

		return  result;
	}
	
}
