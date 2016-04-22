package com.hp.beanAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hp.Dao.TeacherDao;
import com.hp.bean.Subject;
import com.hp.util.Page;
import com.hp.util.PageResult;
import com.opensymphony.xwork2.ActionSupport;

public class QueryListAction extends ActionSupport {
   private Subject subject;
   private int currentPage;
   
   public int getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}

public Subject getSubject() {
	return subject;
}

public void setSubject(Subject subject) {
	this.subject = subject;
}

public String execute() throws Exception{
	   TeacherDao te = new TeacherDao();
	   Page page = new Page();
	   page.setEveryPage(4);
	   page.setCurrentPage(currentPage);
	 

//	   List subjects = te.queryall();
//	   PageResult pageresult = (PageResult) te.queryall(page);
//	   //将subject放到session对象中
//	   ActionContext.getContext().put("subjects",subjects);
//	   return SUCCESS;
	   TeacherDao teacherdao=new TeacherDao();
	   PageResult pageResult=teacherdao.queryall(page);
		List<Subject>subjects=pageResult.getList();
		List<Subject>newSubjects=new ArrayList<Subject>();
		
		for(Subject subject:subjects){
		
			String title=subject.getSubjectTitle();
			String newTitle=subject.getSubjectTitle().replaceAll(title, title);
			subject.setSubjectTitle(newTitle);
			newSubjects.add(subject);
			
			
		}
		
		page=pageResult.getPage();
		HttpServletRequest request=ServletActionContext.getRequest();
	
		request.setAttribute("subjects",newSubjects);
		
		request.setAttribute("page", page);
		return SUCCESS;
	}
	
   }

