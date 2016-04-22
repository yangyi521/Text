package com.hp.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.hp.bean.Student;
import com.hp.bean.Teacher;
import com.hp.util.HibernateSessionFactory;
//学生登录模块
public class LoginImpl {
  public boolean loginStudent(String username,String password){
	  boolean flag = false;
	 Student student = null;
	 List<Student> list = new ArrayList<Student>();
	  Session session = HibernateSessionFactory.getSession();
	  session.beginTransaction();//开启事务
	  System.out.println(username);
	  System.out.println(password);
	 list = session.createQuery("from Student where StudentName=? and StudentPassword = ?").setString(0, username).setString(1, password).list();
	 System.out.print(list.size()+"sdeds");//list一直是空 获取不到里面的东西，
	    //提交事务
		 session.getTransaction().commit();
		 //关闭事物
		 HibernateSessionFactory.closeSession();
	   if(list.size()>0){
		 flag = true;
		 
	   }
	
	    return flag;
	  
  }
  public Student loginStudent2(String username,String password){
	 Student student = null;
	 List<Student> list = new ArrayList<Student>();
	  Session session = HibernateSessionFactory.getSession();
	  session.beginTransaction();//开启事务
	  System.out.println(username);
	  System.out.println(password);
	 list = session.createQuery("from Student where StudentName=? and StudentPassword = ?").setString(0, username).setString(1, password).list();
	 System.out.print(list.size()+"sdeds");//list一直是空 获取不到里面的东西，
	    //提交事务
		 session.getTransaction().commit();
		 //关闭事物
		 HibernateSessionFactory.closeSession();
	   if(list.size()>0){
		 student=list.get(0); 
	   }
	
	    return student;
	  
  }
  
  
//老师登录模块
  public boolean loginTeacher(String username,String password){
	  boolean flag=false;
	     Teacher teacher = null;
		 List list = new ArrayList();
		  Session session = HibernateSessionFactory.getSession();
		  session.beginTransaction();//开启事务
		  list = session.createQuery("from Teacher where TeacherName=:teachername and TeacherPassword=:teacherpassword")
		  .setString("teachername", username).setString("teacherpassword", password).list();
		    //提交事务
			 session.getTransaction().commit();
			 //关闭事物
			 HibernateSessionFactory.closeSession();
		  if(list.size()>0){
			  flag=true;
		  }
		  return flag;
		  
	  }
}
