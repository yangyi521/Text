package com.hp.beanAction;

import com.hp.Dao.TeacherDao;
import com.hp.bean.Subject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectByTitleAction extends ActionSupport {
   private String subjectTitle;
   private Subject subject;

public Subject getSubject() {
	return subject;
}

public void setSubject(Subject subject) {
	this.subject = subject;
}

public String getSubjectTitle() {
	return subjectTitle;
}

public void setSubjectTitle(String subjectTitle) {
	this.subjectTitle = subjectTitle;
}
   public String query() throws Exception{
	   TeacherDao te = new TeacherDao();
	   subject=te.findSubjectBytitle(subjectTitle);
	   ActionContext.getContext().put("subject", subject);
	   return SUCCESS;
   }
}
