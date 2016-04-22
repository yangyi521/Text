package com.hp.beanAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hp.Dao.TestDao;
import com.hp.bean.Subject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetRandomSubject extends ActionSupport {
   TestDao test = new TestDao();
   public String execute() throws Exception{
	   List list = new ArrayList();
	   List<Subject> subjects = test.randomFindSubject(20);
	   HttpServletRequest request = ServletActionContext.getRequest();
	   //抽取的20道题进行遍历 获取其Id
	   for(int i = 0;i<subjects.size();i++){
		   int id = subjects.get(i).getSubjectId();
		   list.add(id);
	   }
	   //request.setAttribute("subjects", subjects);
	   request.getSession().setAttribute("list", list);
	   ActionContext.getContext().put("subjects", subjects);
	   //随机找题  将找到的题保存到ActionContext中
	   return SUCCESS;
	   }
   
}
