package com.yszc.blog.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.yszc.blog.dto.User;

public class BaseController {

	 private Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	public User getCurrentUser(){
		Object obj = getSubject().getPrincipal();
	    if(obj instanceof User){
	    	return (User) obj;
	    }else{
	    	return new User();
	    }
	}
}
