package com.hp.filter;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationInterceptor extends AbstractInterceptor {
   
	  Object object = ActionContext.getContext().get("studentInfo");
	  
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		if(object!=null){
			  return arg0.invoke();
		  }else{
			 // addActionError("请输入正确的用户名跟密码");
			  ((ActionSupport)arg0.getAction()).addActionError("请登录系统");
			  return Action.LOGIN;
		  }
	}

}
