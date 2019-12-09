package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.Entity.User;
import com.cts.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	private String indexPage() {
		return "index";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	private String welcomePage() {
		return "login";
	}
	
	
	@RequestMapping(value="registerpage",method=RequestMethod.GET)
	private String registerPage() {
		return "register";
	}
	
	@RequestMapping(value="registeruser",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") User user)
	{
		  userService.registerUser(user);
		  return new ModelAndView("welcome", "Name", user.getName());
		
		
		
	}
	
	
	
	
	
	@RequestMapping(value="loginuser",method=RequestMethod.POST)//frontend to backend
	private ModelAndView login(@RequestParam("uname")String userName,@RequestParam("pname")String password) throws Exception
	{
		 ModelAndView mav = null;
		 User user=new User(userName,password);
		     userService.loginUser(user);
		    if (null != user) {
		    mav = new ModelAndView("hello");
		    mav.addObject("Name", user.getName());
		    } else {
		    mav = new ModelAndView("login");
		    mav.addObject("message", "Username or Password is wrong!!");
		    }
		    return mav;
		  }
		
		
		
	
}
