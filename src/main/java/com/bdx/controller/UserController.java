package com.bdx.controller;

import java.util.List;  

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
  

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import org.springframework.web.servlet.ModelAndView;

import com.bdx.dto.User;  
import com.bdx.service.IUserService;  

@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/userList")  
    public ModelAndView userList(HttpServletRequest request){  
        List<User> uList = userService.getAllUser();  
        ModelAndView mv = new ModelAndView("hello");  
        mv.addObject("uList", uList);  
        return new ModelAndView("userList", "uList", uList); 
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
//        user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));  
        userService.addUser(user);  
        return "redirect:/user/userList";  
    }  
}  
