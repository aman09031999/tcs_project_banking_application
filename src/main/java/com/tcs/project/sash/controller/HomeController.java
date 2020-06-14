package com.tcs.project.sash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
	
	@GetMapping("/home")
	public String home()
	{
		System.out.println("hi");
		return "home";
	}
	
	@RequestMapping(value = "sash", method= RequestMethod.GET)
	public ModelAndView login()
	{
		String name = "aman";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		System.out.println("value : " + name);
		mv.addObject("name", name);
		
		return mv;
	}
}
