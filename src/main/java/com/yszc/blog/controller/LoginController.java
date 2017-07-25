package com.yszc.blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yszc.blog.dto.User;
import com.yszc.blog.service.Impl.UserServiceImpl;
import com.yszc.blog.utils.BlogResponse;

@Controller
@RequestMapping("/login")   
public class LoginController {  
    @Autowired  
    private UserServiceImpl userService;  
  
    /**
     * @author cqw
      * @date 2017年7月23日下午6:41:15
      * @Description 登录
     */
    @RequestMapping(value = "/dologin",method = RequestMethod.POST) //url  
	public @ResponseBody BlogResponse dologin(User user,HttpServletRequest request){
	    String info = loginUser(user);  
	    BlogResponse res = new BlogResponse();
	    res.success(user);
	    if (!"SUCC".equals(info)) {  
	    	res.failure();
	    }else{  
	    	res.success();
	    }  
	    return res;
	  }  
  
    @RequestMapping(value = "/logout",method = RequestMethod.POST)  
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{  
	    Subject subject = SecurityUtils.getSubject();  
	    if (subject != null) {  
	        try{  
	            subject.logout();  
	        }catch(Exception ex){  
	        }  
	    }  
	    response.sendRedirect("/login.html");  
	}  
  
	private String loginUser(User user) {  
	        if (isRelogin(user)) 
	        	return "SUCC"; // 如果已经登陆，无需重新登录  
	        return shiroLogin(user); // 调用shiro的登陆验证  
	}  
	private String shiroLogin(User user) {  
	    // 组装token，包括客户公司名称、简称、客户编号、用户名称；密码  
	    UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(), null);   
	    token.setRememberMe(true);  
	    // shiro登陆验证  
	    try {  
	        SecurityUtils.getSubject().login(token);  
	    } catch (UnknownAccountException ex) {  
	        return "用户不存在或者密码错误！";  
	    } catch (IncorrectCredentialsException ex) {  
	        return "用户不存在或者密码错误！";  
	    } catch (AuthenticationException ex) {  
	        return ex.getMessage(); // 自定义报错信息  
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	        return "内部错误，请重试！";  
	    }  
	    return "SUCC";  
	}  
  
	private boolean isRelogin(User user) {
	    Subject us = SecurityUtils.getSubject();  
	    
        if (us.isAuthenticated()) {
        	User userAuth = (User) us.getSession().getAttribute(user.getUserName());
        	if(userAuth != null){
        		if(user.getUserName().equals(userAuth.getUserName()) && user.getPassword().equals(userAuth.getPassword())){
            		return true; // 参数未改变，无需重新登录，默认为已经登录成功  
            	}
        	}
        }  
        return false; // 需要重新登陆  
	}  
}  