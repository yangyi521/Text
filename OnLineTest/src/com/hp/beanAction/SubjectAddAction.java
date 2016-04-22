package com.hp.beanAction;



import com.hp.Dao.TeacherDao;
import com.hp.Impl.TeacherService;
import com.hp.bean.Subject;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectAddAction extends ActionSupport {
	 private String subjectTitle;
	 private String subjectOptionA;
	 private String subjectOptionB;
	 private String subjectOptionC;
	 private String subjectOptionD;
	 private String subjectAnswer;
	 private String subjectParse;
	 public String getSubjectTitle() {
			return subjectTitle;
		}


		public void setSubjectTitle(String subjectTitle) {
			this.subjectTitle = subjectTitle;
		}


		public String getSubjectOptionA() {
			return subjectOptionA;
		}


		public void setSubjectOptionA(String subjectOptionA) {
			this.subjectOptionA = subjectOptionA;
		}


		public String getSubjectOptionB() {
			return subjectOptionB;
		}


		public void setSubjectOptionB(String subjectOptionB) {
			this.subjectOptionB = subjectOptionB;
		}


		public String getSubjectOptionC() {
			return subjectOptionC;
		}


		public void setSubjectOptionC(String subjectOptionC) {
			this.subjectOptionC = subjectOptionC;
		}


		public String getSubjectOptionD() {
			return subjectOptionD;
		}


		public void setSubjectOptionD(String subjectOptionD) {
			this.subjectOptionD = subjectOptionD;
		}


		public String getSubjectAnswer() {
			return subjectAnswer;
		}


		public void setSubjectAnswer(String subjectAnswer) {
			this.subjectAnswer = subjectAnswer;
		}


		public String getSubjectParse() {
			return subjectParse;
		}


		public void setSubjectParse(String subjectParse) {
			this.subjectParse = subjectParse;
		}

	public String add(){
		Subject subject = new Subject();//创建试题对象
		subject.setSubjectTitle(subjectTitle);//设置题目
		subject.setOptionA(subjectOptionA);//设置选项A
		subject.setOptionB(subjectOptionB);
		subject.setOptionC(subjectOptionC);
		subject.setOptionD(subjectOptionD);
		subject.setSubjectAnswer(subjectAnswer);//设置答案
		subject.setSubjectExplain(subjectParse);//设置解析
		//创建对象 调用方法
		TeacherService ts = new TeacherService();
		ts.saveSubject(subject);
			return SUCCESS;
		
		}
/*//试题查询
	public String query(){
		 TeacherDao te = new  TeacherDao();
		 Subject sub = new Subject();
		 sub.setSubjectTitle(subjectTitle);
		 Subject subject = te.findSubjectBytitle(sub.getSubjectTitle());
		 return SUCCESS;
	}*/
		

	
//试题更新
	public String update(){
		Subject subject = new Subject();//创建试题对象
		subject.setSubjectTitle(subjectTitle);//设置题目
		subject.setOptionA(subjectOptionA);//设置选项A
		subject.setOptionB(subjectOptionB);
		subject.setOptionC(subjectOptionC);
		subject.setOptionD(subjectOptionD);
		subject.setSubjectAnswer(subjectAnswer);//设置答案
		subject.setSubjectExplain(subjectParse);//设置解析
		//创建对象 调用方法
		TeacherDao ts = new  TeacherDao();
		if(subject!=null){
		ts.addSubject(subject);
		return SUCCESS;
		}else{
			return INPUT;
		}
		
	}	
	
}
