package com.hp.beanAction;
import com.hp.Dao.TeacherDao;
import com.hp.Impl.TeacherService;
import com.hp.bean.Subject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectUpdateAction extends ActionSupport {
	private int subjectId;
	private String subjectTitle;
	private String subjectOptionA;
	private String subjectOptionB;
	private String subjectOptionC;
	private String subjectOptionD;
	private String subjectAnswer;
	private String SubjectExplain;
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
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
	public String getSubjectExplain() {
		return SubjectExplain;
	}
	public void setSubjectExplain(String subjectExplain) {
		SubjectExplain = subjectExplain;
	}
	public String update() throws Exception{
	 //封装对象
		Subject subject = new Subject();
		subject.setSubjectId(subjectId);
		subject.setOptionA(subjectOptionA);
		subject.setOptionB(subjectOptionB);
		subject.setOptionC(subjectOptionC);
		subject.setOptionD(subjectOptionD);
		subject.setSubjectAnswer(subjectAnswer);
		subject.setSubjectTitle(subjectTitle);
		subject.setSubjectExplain(SubjectExplain);
		System.out.println("大小"+subjectId);
		TeacherDao te = new TeacherDao();
		te.updateSubject(subject);
		return SUCCESS;
   }
}