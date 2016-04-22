package com.hp.Impl;

import com.hp.Dao.TeacherDao;
import com.hp.bean.Subject;

public class TeacherService {
   public boolean saveSubject(Subject subject){
	   boolean flag = false;
	   //获取试题的题目
	   String SubTitle = subject.getSubjectTitle();
	   //判断试题是否存在
	   //创建TeacherDao对象，用于调用方法
	   TeacherDao teacher = new TeacherDao();
	   if(teacher.findSubjectBytitle(SubTitle)==null){
		   teacher.addSubject(subject);
		   flag = true;
	   }
	   
	   return flag;
   }
   
    public boolean  updatesubject(Subject subject){
	   boolean flag = false;
	   TeacherDao teacher = new TeacherDao();//创建对象  调用方法
	   teacher.updateSubject(subject);
	   return flag;
	   
   }
  
}
