package com.hp.beanAction;

import com.hp.Dao.StudentDao;
import com.hp.bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class queryByNameAction extends ActionSupport {
    private String StudentName;
    private Student student;
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String execute() throws Exception{
		StudentDao st = new StudentDao();
		student=st.queryByName(StudentName);
		 ActionContext.getContext().put("student",student);
		return SUCCESS;
	}
}
