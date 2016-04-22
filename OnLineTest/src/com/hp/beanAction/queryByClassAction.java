package com.hp.beanAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hp.Dao.StudentDao;
import com.hp.bean.Student;
import com.hp.bean.Subject;
import com.hp.util.Page;
import com.hp.util.PageResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class queryByClassAction extends ActionSupport {
   private String StudentClass;
   private Page page;
   public Page getPage() {
	return page;
}
public void setPage(Page page) {
	this.page = page;
}
private Student student;
public String getStudentClass() {
	return StudentClass;
}
public void setStudentClass(String studentClass) {
	StudentClass = studentClass;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
   public String execute(){
	   StudentDao st = new StudentDao();
   List list = st.queryByClass(StudentClass);
	   ActionContext.getContext().put("student", list);
	   return SUCCESS;
	  /* PageResult pageResult= st.queryByClass(StudentClass);
	   List<Student>subjects=pageResult.getList();
		List<Student>newSubjects=new ArrayList<Student>();
		
		for(Student subject:subjects){
		
			String title=subject.getStudentId();
			String newTitle=subject.getStudentId().replaceAll(title, title);
			subject.setStudentId(newTitle);
			newSubjects.add(subject);
			
			
		}
		
		page=pageResult.getPage();
		HttpServletRequest request=ServletActionContext.getRequest();
	
		request.setAttribute("subjects",newSubjects);
		
		request.setAttribute("page", page);
	   return SUCCESS;*/
   }
}
