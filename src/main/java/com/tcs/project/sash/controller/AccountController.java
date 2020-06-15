package com.tcs.project.sash.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.project.sash.model.Account;
import com.tcs.project.sash.model.AccountType;
import com.tcs.project.sash.services.AccountService;


@Controller
@RequestMapping("sash")
public class AccountController
{
	@Autowired
	private AccountService accountServices;

	private ModelAndView model = new ModelAndView();
	
	@RequestMapping("account/search")
	public ModelAndView searchAccount()
	{
		ModelAndView mv = new ModelAndView("search");
		return mv;
	}
	
	@RequestMapping("account/search/account_id")
	public ModelAndView search_Account(@RequestParam("account_id") String account_id)
	{
		List<Account> account = new ArrayList<>();
		account.add(accountServices.getAccountById(account_id));
		
		ModelAndView mv = new ModelAndView("account_details");
		
		model.addObject("account_id", account_id);
		model.addObject("customer_id", account.get(0).getCustomerId().getcustomer_id());

//		System.out.println("[VALUE] : " + account);
		
		mv.addObject("account", account);
	
		return mv;
	}

/**************************************************************************************************/
	
	@RequestMapping("account/deposit")
	public ModelAndView depositService()
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		ModelAndView mv = new ModelAndView("deposit");
		mv.addObject("account_id", model.getModel().get("account_id").toString());
		mv.addObject("status", model.getModel().get("status"));
		model.addObject("status", "");
		
		return mv;	
	}
	
	@PostMapping("account/deposit/deposit_service")
	public String deposit_Service(@RequestParam("amount") String amount,
									@RequestParam("account_type") String account_type,
									@RequestParam("message") String message)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : deposit_Service");
		
		String status = new String();
		
		if(account_type.equalsIgnoreCase("SAVINGS"))
			status = accountServices.depositMoney(model.getModel().get("account_id").toString(), AccountType.saving, Double.parseDouble(amount), message);
		else
			if(account_type.equalsIgnoreCase("CURRENT"))
				status = accountServices.depositMoney(model.getModel().get("account_id").toString(), AccountType.saving, Double.parseDouble(amount), message);

		ModelAndView mv = new ModelAndView("deposit");

			mv.addObject("account_id", model.getModel().get("account_id").toString());
			model.addObject("status", status);
		
		System.out.println("Account ID   : " + model.getModel().get("account_id").toString());
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
			mv.addObject("account_id", model.getModel().get("account_id").toString());
			mv.addObject("status", model.getModel().get("status"));
			model.addObject("status", "");
		
		return mv;	
	}
	
	@PostMapping("account/withdraw/withdraw_service")
	public String withdraw_Service(@RequestParam("account_id") String account_id,
										@RequestParam("amount") String amount,
										@RequestParam("account_type") String account_type,
										@RequestParam("message") String message)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : withdraw_Service");
		
		String status = new String();
		
		if(account_type.equalsIgnoreCase("SAVINGS"))
		{
			status = accountServices.withdrawMoney(account_id, AccountType.saving, Double.parseDouble(amount), message);
		}
		if(account_type.equalsIgnoreCase("CURRENT"))
		{
			status = accountServices.withdrawMoney(account_id, AccountType.saving, Double.parseDouble(amount), message);
		}

		ModelAndView mv = new ModelAndView("withdraw");

			mv.addObject("account_id", model.getModel().get("account_id").toString());
			model.addObject("status", status);
		
		System.out.println("Account ID   : " + account_id);
		System.out.println("Amount       : " + amount);
		System.out.println("Account Type : " + account_type);

		return "redirect:";
	}
	
/**********************************************************************************************************/	

	@RequestMapping("account/transfer")
	public ModelAndView transferMoney()
	{	
		ModelAndView mv = new ModelAndView("transfer");
			mv.addObject("account_id", model.getModel().get("account_id").toString());
			mv.addObject("status", model.getModel().get("status"));
		
		model.addObject("status", "");
		
		return mv;
	}
	
	@PostMapping("account/transfer/account_id")
	public String transfer_Money(@RequestParam("amount") double amount,
								@RequestParam("source_account") String source,
								@RequestParam("destination_account") String destination,
								@RequestParam("message") String message)
	{
		ModelAndView mv = new ModelAndView("transfer");
		String status = new String();
		
		if(source.equals(destination))
		{
			mv.addObject("status", "Source and Destination account are same...!!!");			
			
			mv.addObject("account_id", model.getModel().get("account_id").toString());
			mv.addObject("status", status);
				
			model.addObject("status", status);
			return "redirect:";
		}
		
		if(source.equalsIgnoreCase("SAVINGS"))
		{
			status = accountServices.transferMoney(model.getModel().get("customer_id").toString(), AccountType.saving, AccountType.current, amount, message);
			mv.addObject("account_id", model.getModel().get("account_id").toString());
			mv.addObject("status", status);
				
			model.addObject("status", status);
			return "redirect:";
		}
		else
		{	if(source.equalsIgnoreCase("CURRENT"))
			{
				status = accountServices.transferMoney(model.getModel().get("customer_id").toString(), AccountType.current, AccountType.saving, amount, message);
				
				mv.addObject("account_id", model.getModel().get("account_id").toString());
				mv.addObject("status", status);
					
				model.addObject("status", status);
				return "redirect:";
			}
		}
		
		model.addObject("status", status);
		return "redirect:";
	}
	
/****************************************************************************************/
	
	@RequestMapping("account/displayAll")
	public ModelAndView displayAllAccounts()
	{
		ModelAndView mv = new ModelAndView("accounts");
		mv.addObject("accounts", accountServices.getAllAccounts());
		return mv;
		
	}
}
