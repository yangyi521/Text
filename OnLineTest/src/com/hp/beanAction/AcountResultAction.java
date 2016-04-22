package com.hp.beanAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hp.Dao.StudentDao;
import com.hp.bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AcountResultAction extends ActionSupport {
    private List<Integer> subjectID;
	public List<Integer> getSubjectsId() {
		return subjectID;
	}
	public void setSubjectsId(List<Integer> subjectsId) {
		this.subjectID = subjectsId;
	}
    //创建对象调用方法
	StudentDao st = new StudentDao();
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();//创建request对象
		List<String> studentAnswers = new ArrayList<String>();//创建list对象，用于存放学生的答案
		for(int i=0;i<20;i++){
			String answer = request.getParameter("subjectAnswer"+i);
			studentAnswers.add(answer);
		}
		System.out.println("学生答案"+studentAnswers);
		System.out.println("试题序号"+subjectID);
		//从list中取出数据
		List list = (List) request.getSession().getAttribute("list");
		System.out.println("从session中获取的对象"+list);
		int GeneralResult = st.acountResult(list, studentAnswers);//调用方法  计算总成绩
		//设置成绩到学生信息中
	    System.out.println("学生成绩"+GeneralResult);
		Map session = ActionContext.getContext().getSession();
		Student student = (Student)session.get("studentInfo"); //登录的时候在session中保存的信息 现在取出来
		String studentId = student.getStudentId(); //获取该学生的Id
		System.out.println("测试"+studentId);
		st.setStudentResult(studentId, GeneralResult);//以Id作为参照，跟新学生的成绩属性
		request.setAttribute("studentName", student.getStudentName());
		request.setAttribute("GeneralPoint",GeneralResult);
		session.put("subjectIDs", subjectID);
		return SUCCESS;
	}
}
