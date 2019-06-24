package com.dns.springboot3.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.dns.springboot3.form.UserForm;
import com.dns.springboot3.service.ContactService;
import com.dns.springboot3.service.UserService;
import com.dns.springboot3.utils.WebUtils;

@Controller
public class UserController  {
	@RequestMapping(value= {"/","/welcome"}, method=RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "index";
	}
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
		User loginedUser = (User)((Authentication)principal).getPrincipal();
		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("Name", loginedUser.getUsername());
		model.addAttribute("userInfor", userInfo);
		return "adminPage";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(Model model) {
		return "loginPage";
	}
	@RequestMapping(value="/logoutSuccessful", method=RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "logout");
		return "loginPage";
	}
	@Autowired
    private ContactService contactService;
	@RequestMapping(value="/userInfo", method=RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println("User Name : " + userName);
		User loginUser = (User)((Authentication)principal).getPrincipal();
		String userInfo = WebUtils.toString(loginUser);
		model.addAttribute("Name", userName);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("contacts", contactService.findAll());
		return "list";
	}
	@RequestMapping(value="/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		if(principal != null) {
			User loginedUser = (User)((Authentication)principal).getPrincipal();
			String userInfo = WebUtils.toString(loginedUser);
			model.addAttribute("userInfo", userInfo);
			String message = "hi " + principal.getName() + "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);
		}
		return "403Page";
	}
	
	
//	@Autowired private UserService userService;
//	
//	 @RequestMapping("/")  
//	  public String index(Model model) {  
//	    List<User> users = userService.getAllUser();  
//
//	    model.addAttribute("users", users);  
//
//	    return "index";  
//	  }  
//	 @RequestMapping(value = "add")  
//	  public String addUser(Model model) {  
//	    model.addAttribute("user", new User());  
//	    return "addUser";  
//	  }
//	 @RequestMapping(value = "edit", method = RequestMethod.GET)  
//	  public String editUser(@RequestParam("id") Long userId, Model model) {  
//	    Optional<User> userEdit = userService.findUserById(userId);  
//	    userEdit.ifPresent(user -> model.addAttribute("user", user));  
//	    return "editUser";  
//	  }  
//	 @RequestMapping(value = "save", method = RequestMethod.POST)  
//	  public String save(User user) {  
//	    userService.saveUser(user);  
//	    return "redirect:/";  
//	  }
//	 @RequestMapping(value = "/delete", method = RequestMethod.GET)  
//	  public String deleteUser(@RequestParam("id") Long userId, Model model) {  
//	    userService.deleteUser(userId);  
//	    return "redirect:/";  
//	  } 
    
}
