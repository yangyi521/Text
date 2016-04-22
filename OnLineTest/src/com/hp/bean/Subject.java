package com.hp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Subject{
 private int SubjectId;
 private String SubjectTitle;
 private String OptionA;
 private String OptionB;
 private String OptionC;
 private String OptionD;
 private String SubjectAnswer;
 private String SubjectExplain;
 @Id
 @GeneratedValue
public int getSubjectId() {
	return SubjectId;
}
public void setSubjectId(int subjectId) {
	SubjectId = subjectId;
}
public String getSubjectTitle() {
	return SubjectTitle;
}
public void setSubjectTitle(String subjectTitle) {
	SubjectTitle = subjectTitle;
}
public String getOptionA() {
	return OptionA;
}
public void setOptionA(String optionA) {
	OptionA = optionA;
}
public String getOptionB() {
	return OptionB;
}
public void setOptionB(String optionB) {
	OptionB = optionB;
}
public String getOptionC() {
	return OptionC;
}
public void setOptionC(String optionC) {
	OptionC = optionC;
}
public String getOptionD() {
	return OptionD;
}
public void setOptionD(String optionD) {
	OptionD = optionD;
}
public String getSubjectAnswer() {
	return SubjectAnswer;
}
public void setSubjectAnswer(String subjectAnswer) {
	SubjectAnswer = subjectAnswer;
}
public String getSubjectExplain() {
	return SubjectExplain;
}
public void setSubjectExplain(String subjectExplain) {
	SubjectExplain = subjectExplain;
}
 
}
