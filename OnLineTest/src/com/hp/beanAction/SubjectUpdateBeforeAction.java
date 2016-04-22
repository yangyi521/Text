package com.hp.beanAction;

import com.hp.Dao.TeacherDao;
import com.hp.bean.Subject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectUpdateBeforeAction extends ActionSupport {
    private int subjectId;

	public int getStudentId() {
		return subjectId;
	}

	public void setStudentId(int studentId) {
		this.subjectId = studentId;
	}
	public String execute() throws Exception{
		TeacherDao te = new TeacherDao();
		Subject subject = te.findSubjectById(subjectId);//通过id查找到该对象
		System.out.println("大小"+subjectId);
		//将subject放到session中
		ActionContext.getContext().put("subject", subject);
		System.out.println(subject);
		return SUCCESS;
	}
	
}
