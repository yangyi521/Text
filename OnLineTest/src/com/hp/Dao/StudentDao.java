package com.hp.Dao;

import java.util.List;

import org.hibernate.Session;

import com.hp.bean.Student;
import com.hp.util.HibernateSessionFactory;
import com.hp.util.Page;
import com.hp.util.PageResult;
import com.hp.util.PageUtil;

public class StudentDao {
 public Student queryByName(String StudentName){
	 Student student = null;
	 List list = null;
	Session session = HibernateSessionFactory.getSession();
	 session.beginTransaction();
	 list =  session.createQuery("from Student where StudentName=:StudentName")
	 .setString("StudentName", StudentName).list();
	 session.getTransaction().commit();
	 HibernateSessionFactory.closeSession();
	 if(list.size()>0){
		 student=(Student) list.get(0);
	 }
	 return student;
 }
public void updateStudent(Student student) throws Exception{
	Session session = HibernateSessionFactory.getSession();
	session.beginTransaction();
	session.update(student);
    session.getTransaction().commit();
    HibernateSessionFactory.closeSession();
}
 

 public List queryByClass(String StudentClass){
	 List list=null;
	 Session session = HibernateSessionFactory.getSession();
	 session.beginTransaction();
	 list = session.createQuery("from Student where StudentClass=:StudentClass")
			 .setString("StudentClass", StudentClass).list();
	 session.getTransaction().commit();
	 HibernateSessionFactory.closeSession();
	 return list;
 }
 /*public PageResult queryByClass(String StudentClass,Page page){
	 List list=null;
	 StudentDao st = new StudentDao();
	 int count = st.queryByClass(StudentClass).size();
	 Session session = HibernateSessionFactory.getSession();
	 session.beginTransaction();
	 page =PageUtil.createPage(page.getEveryPage(),count, page.getCurrentPage());
	 list = session.createQuery("from Student where StudentClass=:StudentClass")
			 .setString("StudentClass", StudentClass).list();
	 session.getTransaction().commit();
	 PageResult result=new PageResult(page,list);
	// HibernateSessionFactory.closeSession();
	 return result;
 }*/
 public int acountResult(List<Integer> subjectsIds,List<String> studentAnswer){
	 int GeneralAcount=0;
	 TeacherDao te = new TeacherDao();
	 for(int i=0;i<subjectsIds.size();i++){
		 System.out.println(subjectsIds.size());
		 //通过试题答案得到正确的Id
		 String rightAnswer = te.findSubjectById(subjectsIds.get(i)).getSubjectAnswer();
		 if(rightAnswer.equals(studentAnswer.get(i))){
			 GeneralAcount+=5;
			 System.out.println("dafdfa");
		 }
	 }
	 return GeneralAcount;
 }
 //通过Id查询Student
 public Student queryById(String studentId){
	 List list = null;
	 Student student = null;
	 Session session = HibernateSessionFactory.getSession();
	 session.beginTransaction();
	 list = session.createQuery("from Student where StudentId =:StudentId").setString("StudentId", studentId).list();
	 session.getTransaction().commit();
	 HibernateSessionFactory.closeSession();
	 if(list.size()>0){
		 student=(Student)list.get(0);
	 }
	 return student;
 }
 //将考试成绩更新到数据库
 public void setStudentResult(String studentId,int result) throws Exception{
	 StudentDao sd = new StudentDao(); 
	 TeacherDao te = new TeacherDao();
	 Student student = sd.queryById(studentId);//根据Id查找到对象
	 student.setStudentresult(result);//给该对象赋值，将新的成绩福给该对象
	StudentDao st = new StudentDao();
	 //调用更新方法
	st.updateStudent(student);
 }
}
