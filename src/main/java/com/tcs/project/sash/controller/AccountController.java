package com.tcs.project.sash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.project.sash.model.AccountType;
import com.tcs.project.sash.services.AccountService;

@Controller
@RequestMapping("sash")
public class AccountController
{
	@Autowired
	private AccountService accountServices;
	
	private ModelAndView model = new ModelAndView();

	@RequestMapping("account/deposit")
	public ModelAndView depositService()
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		ModelAndView mv = new ModelAndView("deposit");
		mv.addObject("status", model.getModel().get("status"));
		model.addObject("status", "");
		
		return mv;	
	}
	
	@PostMapping("account/deposit/deposit_service")
	public String deposit_Service(@RequestParam("account_id") String account_id,
										@RequestParam("amount") String amount,
										@RequestParam("account_type") String account_type)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : deposit_Service");
		
		String status = new String();
		
		if(account_type.equalsIgnoreCase("SAVINGS"))
			status = accountServices.depositMoney(account_id, AccountType.saving, Double.parseDouble(amount));
		else
			if(account_type.equalsIgnoreCase("CURRENT"))
				status = accountServices.depositMoney(account_id, AccountType.saving, Double.parseDouble(amount));

		ModelAndView mv = new ModelAndView("deposit");

			mv.addObject("account_id", account_id);
			mv.addObject("amount", amount);
			mv.addObject("account_type", account_type);
			model.addObject("status", status);
		
		System.out.println("Account ID   : " + account_id);
		System.out.println("Amount       : " + amount);
		System.out.println("Account Type : " + account_type);

		return "redirect:";	
	}
	
/**********************************************************************************************************/	
	
	@RequestMapping("account/withdraw")
	public ModelAndView withdrawService()
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : withdrawService");
		
		ModelAndView mv = new ModelAndView("withdraw");
		mv.addObject("status", model.getModel().get("status"));
		model.addObject("status", "");
		
		return mv;	
	}
	
	@PostMapping("account/withdraw/withdraw_service")
	public String withdraw_Service(@RequestParam("account_id") String account_id,
										@RequestParam("amount") String amount,
										@RequestParam("account_type") String account_type)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : withdraw_Service");
		
		String status = new String();
		
		if(account_type.equalsIgnoreCase("SAVINGS"))
		{
			status = accountServices.withdrawMoney(account_id, AccountType.saving, Double.parseDouble(amount));
		}
		if(account_type.equalsIgnoreCase("CURRENT"))
		{
			status = accountServices.withdrawMoney(account_id, AccountType.saving, Double.parseDouble(amount));
		}

		ModelAndView mv = new ModelAndView("withdraw");

			mv.addObject("account_id", account_id);
			mv.addObject("amount", amount);
			mv.addObject("account_type", account_type);
			model.addObject("status", status);
		
		System.out.println("Account ID   : " + account_id);
		System.out.println("Amount       : " + amount);
		System.out.println("Account Type : " + account_type);

		return "redirect:";
	}
}
