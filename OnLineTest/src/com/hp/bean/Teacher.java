package com.hp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Teacher {
  private String TeacherId;
  private String TeacherName;
  private String TeacherPassword;
 
  @Id
  @GeneratedValue
public String getTeacherId() {
	return TeacherId;
}
public void setTeacherId(String teacherId) {
	TeacherId = teacherId;
}
public String getTeacherName() {
	return TeacherName;
}
public void setTeacherName(String teacherName) {
	TeacherName = teacherName;
}
public String getTeacherPassword() {
	return TeacherPassword;
}
public void setTeacherPassword(String teacherPassword) {
	TeacherPassword = teacherPassword;
}
  
}
