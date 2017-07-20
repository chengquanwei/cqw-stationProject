package com.bdx.controller;

import javax.servlet.http.HttpServletRequest;  
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bdx.dto.User;  
import com.bdx.service.IUserService;  
import com.bdx.utils.SiteResponse;

@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Autowired  
    private IUserService userService;  
      
//    @RequestMapping("/userList")  
//    public ModelAndView userList(HttpServletRequest request){  
//        List<User> uList = userService.getAllUser();  
//        return new ModelAndView("userList", "uList", uList); 
//    }  
    
//  @RequestMapping("/index")  
//  public ModelAndView index(){
//	  SiteResponse res = new SiteResponse();
//      return new ModelAndView("userList"); 
//  }
  
  @RequestMapping(value = "/userList",method = RequestMethod.POST)
  public @ResponseBody SiteResponse userList(HttpServletRequest request){  
//    List<User> uList = userService.getAllUser();  
	  SiteResponse res = new SiteResponse();
	  res.success("framework实现前后端分离");
    return res; 
  }
    
      
    @RequestMapping("/showUser")  
    public String showUser(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  
      
    @RequestMapping("/addUserUI")  
    public String addUserUI(){  
        return "addUser";  
    }  
      
    @RequestMapping("/addUser")  
    public String addUser(HttpServletRequest request,Model model){  
        User user = new User();  
        user.setUserName(String.valueOf(request.getParameter("name")));  
        user.setPassword(String.valueOf(request.getParameter("password")));  
//      user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));  
        userService.addUser(user);  
        return "redirect:/user/userList";  
    }  
}  
