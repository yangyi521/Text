package com.hp.beanAction;

import org.apache.struts2.ServletActionContext;

import com.hp.Dao.TeacherDao;
import com.hp.Impl.SubjectService;
import com.hp.bean.Subject;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectParticularAction extends ActionSupport {
  private  int subjectId;
  private SubjectService subjectservice = new SubjectService();
public int getSubjectId() {
	return subjectId;
}

public void setSubjectId(int subjectId) {
	this.subjectId = subjectId;
}
public String execute(){
	TeacherDao te = new TeacherDao();
	//根据试题的ID查询试题 
	Subject subject = te.findSubjectById(subjectId);
	ServletActionContext.getRequest().setAttribute("subject", subject);
	return SUCCESS;
}
  
}
