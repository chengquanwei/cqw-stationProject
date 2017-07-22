package com.yszc.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;  
  





import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;  
  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yszc.blog.dto.User;
import com.yszc.blog.service.IUserService;
import com.yszc.blog.utils.BlogResponse;

@Controller  
@RequestMapping("/user")  
public class UserController {  
  Logger logger = Logger.getLogger(UserController.class);
  @Autowired  
  private IUserService userService;  
   
	/**
	 * @author cqw
	 * @date 2017年7月22日上午11:12:15
	 * @Description 测试用例
	 */
  @RequestMapping(value = "/userList",method = RequestMethod.POST)
  public @ResponseBody BlogResponse userList(HttpServletRequest request){  
	  logger.info("into userList.");
	  List<User> uList = userService.getAllUser();  
	  BlogResponse res = new BlogResponse();
	  res.success(uList);
    return res; 
  }
}  
