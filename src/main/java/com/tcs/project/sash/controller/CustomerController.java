package com.tcs.project.sash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController
{
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("home");
		System.out.println("hi");
		return mv;
	}
}
