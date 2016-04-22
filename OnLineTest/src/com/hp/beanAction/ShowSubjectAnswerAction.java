package com.hp.beanAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hp.Dao.TeacherDao;
import com.hp.bean.Subject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowSubjectAnswerAction extends ActionSupport {
   public String execute() throws Exception{
	   TeacherDao te = new TeacherDao();//创建对象，来调用方法
	   List<Subject> subjects = new ArrayList<Subject>();//保存学生做过的试题
	   HttpServletRequest request = ServletActionContext.getRequest();
	   Map session = ActionContext.getContext().getSession();
	   List<Integer> SubjectIDs = (List) request.getSession().getAttribute("list");
	   for(Integer SubjectId:SubjectIDs){
		   //通过试题编号查找试题
		   Subject subject = te.findSubjectById(SubjectId);
		   subjects.add(subject);
		   
	   }
	   System.out.println("试题集"+subjects);
	   request.setAttribute("subjects",subjects);
	   return SUCCESS;
   }
}
