package com.tcs.project.sash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.project.sash.services.TransactionService;

@Controller
@RequestMapping("sash")
public class TransactionController
{
	@Autowired
	private TransactionService txService;

	@RequestMapping("banking/transaction/all")
	public ModelAndView displayAllTransaction()
	{
		ModelAndView mv = new ModelAndView("banking/transactions");
		mv.addObject("transaction", txService.getAllTransaction());
		
		return mv;
	}
}
