package com.hp.Test;

import org.hibernate.Session;

import com.hp.bean.Subject;
import com.hp.beanAction.SubjectAddAction;
import com.hp.util.HibernateSessionFactory;

public class Test {

	@org.junit.Test
	public void test() {
	 Session session = HibernateSessionFactory.getSession();
	 session.beginTransaction();
	 Subject subject = new Subject();//创建试题对象
		/*subject.setSubjectTitle("111");//设置题目
		subject.setOptionA("111");//设置选项A
		subject.setOptionB("111");
		subject.setOptionC("111");
		subject.setOptionD("111");
		subject.setSubjectAnswer("111");//设置答案
		subject.setSubjectExplain("111");*///设置解析
	    SubjectAddAction sub = new SubjectAddAction();
	         sub.add();
	 
		session.save(subject);
		session.getTransaction().commit();
		 HibernateSessionFactory.closeSession();
	}

}
