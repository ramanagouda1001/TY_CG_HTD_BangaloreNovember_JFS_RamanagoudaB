package com.capgemini.springmvc.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.capgemini.springmvc.beans.User;

@Controller
public class SpringController {
	@Autowired
	private ServletContext context;
	@RequestMapping("/hello")
	public String hello(ModelMap map) {
		map.addAttribute("msg", "hello world---------------------");
		return "index";
	}

//	@RequestMapping(path="/query",method = RequestMethod.GET)
	@GetMapping("/query") // same as do get method
	public String query(@RequestParam(name = "name", required = false, defaultValue = "hi") String name,
			@RequestParam(name = "age", required = false, defaultValue = "20") int age, ModelMap map) {
		map.addAttribute("name", name);
		map.addAttribute("age", age);
		return "query";
	}

	@GetMapping("/form")
	public String form() {
		return "form";
	}

	@PostMapping("/form")
	public String form(User use, ModelMap map) {
		map.addAttribute("name", use.getName());
		map.addAttribute("email", use.getEmail());
		map.addAttribute("password", use.getPassword());
		map.addAttribute("gender", use.getGender());
		return "form";
	}

	@GetMapping("/createcookie")
	public String createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("name", "Akshay");
		response.addCookie(cookie);
		return "createcookie";
	}

	@GetMapping("/getCookie")
	public String getCookie(@CookieValue(name = "name", required = false) String name, ModelMap map) {
		if (name != null) {
			map.addAttribute("name", name);
			return "getCookie";
		} else {
			map.addAttribute("name", "Rohan");
		}
		return name;
	}

	@GetMapping("/pathValue/{movie}/{hero}")
	public String path(@PathVariable("movie") String movie, @PathVariable("hero") String hero, ModelMap map) {
		map.addAttribute("movie", movie);
		map.addAttribute("hero", hero);
		return "pathValue";
	}

	// forwarding
	@GetMapping("/forward")
	public String forward() {
		return "forward:hello";
	}

	// redirecting

	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:https://www.google.com";
	}

	@GetMapping("/login")
	public String login(HttpSession session) {
		return "login";
	}

	@PostMapping("/login")
	public String login(String username, String password, HttpServletRequest request, ModelMap map) {
		if (username.equalsIgnoreCase("Ironman") && password.equalsIgnoreCase("Qwerty")) {
			User user = new User();
			user.setName(username);
			user.setEmail("Hello@gmail.com");
			user.setGender("O");
			user.setPassword(password);
			// request.getSession();
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			map.addAttribute("msg", "Sucessfully");
			return "home";
		} else {
			map.addAttribute("msg", "bye");
			return "login";
		}

	}

	@GetMapping("/home")
	public String home(@SessionAttribute(name="user",required = false) User user) {
		if(user!=null)
			return "home";
		else
			return "login";
	}
	
	@GetMapping("setappattribute")
	public String setAppAttribute()
	{
		context.setAttribute("msg",new Object());
		return "setcontext";
	}
	@GetMapping("getappattribute")
	public String getAppAttribute()
	{
		System.out.println(context.getAttribute("msg"));
		return "getcontext";
	}
}
