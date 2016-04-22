package com.hp.beanAction;

import com.hp.Dao.TeacherDao;
import com.hp.bean.Subject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectDeleteAction extends ActionSupport{
    private int subjectId;
    private Subject subject;

	public int getSubjectId() {
		return subjectId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
    public String delete() throws Exception{
    	TeacherDao te = new TeacherDao();
    	te.deleteSubject(subjectId);//调用删除的方法
    	return SUCCESS;
    }
    public String query() throws Exception{
    	TeacherDao te = new TeacherDao();
    	subject=te.findSubjectById(subjectId);
    	System.out.println(subjectId);
    	ActionContext.getContext().put("subject",subject);
    	return SUCCESS;
    }
}
