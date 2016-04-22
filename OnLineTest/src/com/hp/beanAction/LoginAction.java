package com.hp.beanAction;

import com.hp.Dao.LoginImpl;
import com.hp.bean.Student;
import com.hp.bean.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
 private String username;
 private String password;
 private String role;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

 public String execute() throws Exception{
	 LoginImpl login = new LoginImpl();
	 if(role.equals("student")){  //判断，以学生的身份登录
		 Student student = new Student();
		 //student.setStudentName(username);
		 //student.setStudentPassword(password);
		boolean flag =login.loginStudent(username, password);
		 student = login.loginStudent2(username, password);
		 //System.out.println("aotuman"+student.getStudentName());
		 ActionContext.getContext().getSession().put("studentInfo", student);
		if(flag){
			return "studentsuccess";
		}else{
		addActionError("请输入正确的用户名跟密码");
		return ERROR;	
		}
		
		 //ActionContext.getContext().getSession().put("studentInfo", student);
		 
	 } else if(role.equals("teacher")){
		 Teacher teacher = new Teacher();
		 boolean flag=login.loginTeacher(username, password); 
		 if(flag){
			 return "teachersuccess";
		 }else{
			 addActionError("请输入正确的用户名跟密码");
			 return ERROR;
		 }
		 
	 }else{
		 addActionError("请输入正确的用户名跟密码");
		 return INPUT;
	 }
	 
 }
}
