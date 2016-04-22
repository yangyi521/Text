package com.hp.Impl;

import com.hp.Dao.TeacherDao;
import com.hp.bean.Subject;

public class SubjectService {
	TeacherDao te = new TeacherDao();
  public Subject showSubjectParticular(int subjectId ){
	  
	  return te.findSubjectById(subjectId);
  }
  public void updateSubject(Subject subject){
	  //te.updateSubject(subject);
  }
  public void deleteSubject(int subjectId){
	  te.deleteSubject(subjectId);
  }
}
