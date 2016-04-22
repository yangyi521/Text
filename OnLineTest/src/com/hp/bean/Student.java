package com.hp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Student {
private String StudentId;
private String StudentName;
private String StudentPassword;
private Integer Studentresult;
private String  StudentClass;
@Id
@GeneratedValue
public String getStudentId() {
	return StudentId;
}
public void setStudentId(String studentId) {
	StudentId = studentId;
}
public String getStudentName() {
	return StudentName;
}
public void setStudentName(String studentName) {
	StudentName = studentName;
}
public String getStudentPassword() {
	return StudentPassword;
}
public void setStudentPassword(String studentPassword) {
	StudentPassword = studentPassword;
}
public Integer getStudentresult() {
	return Studentresult;
}
public void setStudentresult(Integer studentresult) {
	Studentresult = studentresult;
}
public String getStudentClass() {
	return StudentClass;
}
public void setStudentClass(String studentClass) {
	StudentClass = studentClass;
}

}
