package com.capgemini.empspringmvc.controller;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.empspringmvc.bean.EmployeeBean;
import com.capgemini.empspringmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService Service;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String email, String password, ModelMap map, HttpServletRequest request) {
		EmployeeBean bean=Service.auth(email, password);
		if(bean==null)
		{
			map.addAttribute("msg", "Invalid cred");
			return "login";
		}
		HttpSession  session=request.getSession();
		session.setAttribute("bean",bean);
		return "home";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String register(EmployeeBean bean,ModelMap map) {
		if (Service.register(bean)) {
			
			map.addAttribute("msg","YOU have regsitser to employee portel");
		} else {
			map.addAttribute("msg","Repeat Email!!!!!!!!!!!!!!!!!!!");
		}
		return "login";
	}
	
	@GetMapping("/serach")
	public String search(@RequestParam("key")String key,ModelMap map,@SessionAttribute(name="bean",required = false) EmployeeBean bean)
	{
		if(bean!=null)
		{
		List<EmployeeBean> list=Service.getAllEmployees(key);
		map.addAttribute("list",list);
		return "home";
		}
		else
		{
			return "login";
		}
	}
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name="bean",required = false) EmployeeBean bean)
	{
		if(bean!=null)
			return "home";
		else
			return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	@GetMapping("/changepassword")
	public String changePassword(@SessionAttribute(name="bean",required = false) EmployeeBean bean)
	{
		if(bean!=null)
			return "changepassword";
		else
			return "login";
	}
	
	
	@PostMapping("/changepassword")
	public String ChangePassword(String password,@SessionAttribute("bean") EmployeeBean bean)
	{
		Service.changePassword(bean.getId(), password);
		return "home";
	}
}
