package com.tcs.project.sash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sash")
public class HomeController
{
	@RequestMapping(value = "login", method= RequestMethod.GET)
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
