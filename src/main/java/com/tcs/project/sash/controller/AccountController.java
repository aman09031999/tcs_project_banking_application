package com.tcs.project.sash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.project.sash.model.Account;
import com.tcs.project.sash.model.AccountType;
import com.tcs.project.sash.model.Customer;
import com.tcs.project.sash.services.AccountService;
import com.tcs.project.sash.services.CustomerService;
import com.tcs.project.sash.services.TransactionService;


@Controller
@RequestMapping("sash")
public class AccountController
{
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TransactionService txService;
	
//	private ModelAndView model = new ModelAndView();
	private Account account = new Account();
	private Customer customer = new Customer();
	
/*************************************************************************************************************/
	
	@RequestMapping("banking")
	public ModelAndView searchBanking()
	{
		ModelAndView mv = new ModelAndView("banking/home");
		return mv;
	}
	
/**********************************|	SEARCH Account By ID [completed]	|**********************************************************************/
	
	@RequestMapping("banking/account/search")
	public ModelAndView add()
	{
		ModelAndView mv = new ModelAndView("banking/search");
		return mv;
	}

	@RequestMapping("banking/account/search/id")
	public ModelAndView searchAccount(@RequestParam("id") String id)
	{
		if(id != null)
		{
			account = accountService.getAccountById(id);
			System.out.println(account);
			
			if(account.getAccountId() != null)
			{
				ModelAndView mv = new ModelAndView("banking/account");
				mv.addObject("account", account);
				return mv;
			}
			
			ModelAndView mv = new ModelAndView("banking/search");
			mv.addObject("alert", "Account ID is Invalied or Account is not avaiable...!!");
			return mv;
		}
		
		ModelAndView mv = new ModelAndView("banking/search");
		mv.addObject("alert", "Please Enter Account ID..!!!");
		return mv;
	}
	
/***************************************************| DESPOSIT SERVICE [COMPLETED] |**********************************************************/
	
	//	Display Search Page for Deposit Service
	@RequestMapping("banking/account/deposit/search")
	public ModelAndView depositService()
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		ModelAndView mv = new ModelAndView("banking/search_deposit");
		return mv;	
	}
	
	//	Navigate to Deposit Page via Deposit Option
	@RequestMapping("banking/account/deposit/search/id")
	public ModelAndView navigateToDepositService(@RequestParam("id") String id)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		if(id != null)
		{
			account = accountService.getAccountById(id);

			if(account.getAccountId().equalsIgnoreCase(id))
			{
				System.out.println("Account Details : " + account);
				ModelAndView mv = new ModelAndView("banking/deposit");
				mv.addObject("account", account);
				return mv;
			}
			
			ModelAndView mv = new ModelAndView("banking/search_deposit");
			mv.addObject("alert", "Account ID is Invalied or Account is not avaiable...!!");
			return mv;
		}
			
			ModelAndView mv = new ModelAndView("banking/search_deposit");
			mv.addObject("account", account);
			mv.addObject("alert", "Please Enter Account ID..!!!");
			return mv;
	}
	
	//	Navigate to Deposit Page via Search Option
	@RequestMapping("banking/account/deposit/search/id2")
	public ModelAndView depositServiceFromSearch()
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		if(account != null)
		{
			System.out.println("Account Details : " + account);
			ModelAndView mv = new ModelAndView("banking/deposit");
			mv.addObject("account", account);
			return mv;
		}
			
			ModelAndView mv = new ModelAndView("banking/search_deposit");
			mv.addObject("account", account);
			mv.addObject("alert", "Please Enter Account ID..!!!");
			return mv;
	}

	//	Process Deposit Request
	@PostMapping("banking/account/deposit")
	public ModelAndView processDepositRequest(@RequestParam("amount") String amount, @RequestParam("message") String message)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : deposit_Service");
		
		
		ModelAndView mv = new ModelAndView("banking/deposit");
		mv.addObject("account", account);
		String status = new String();
		
		if(account.getAccountType().equals(AccountType.saving))
			status = accountService.depositMoney(account.getAccountId(), AccountType.saving, Double.parseDouble(amount), message);
		else
			if(account.getAccountType().equals(AccountType.current))
				status = accountService.depositMoney(account.getAccountId(), AccountType.current, Double.parseDouble(amount), message);

		mv.addObject("alert", status);
		

		return mv;
	}
	
/****************************************|	WITHDRAW SERVICE [COMPLETED]	|******************************************************************/	
	
	//	Display Search Page for Withdraw Service
	@RequestMapping("banking/account/withdraw/search")
	public ModelAndView withdrawService()
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		ModelAndView mv = new ModelAndView("banking/search_withdraw");
		return mv;	
	}
	
	//	Navigate to Deposit Page via Withdraw Option
	@RequestMapping("banking/account/withdraw/search/id")
	public ModelAndView navigateToWithdrawService(@RequestParam("id") String id)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		if(id != null)
		{
			account = accountService.getAccountById(id);

			if(account.getAccountId().equalsIgnoreCase(id))
			{
				System.out.println("Account Details : " + account);
				ModelAndView mv = new ModelAndView("banking/withdraw");
				mv.addObject("account", account);
				return mv;
			}
			
			ModelAndView mv = new ModelAndView("banking/search_withdraw");
			mv.addObject("alert", "Account ID is Invalied or Account is not avaiable...!!");
			return mv;
		}
			
			ModelAndView mv = new ModelAndView("banking/search_withdraw");
			mv.addObject("account", account);
			mv.addObject("alert", "Please Enter Account ID..!!!");
			return mv;
	}

	//	Navigate to Deposit Page via Search Option
	@RequestMapping("banking/account/withdraw/search/id2")
	public ModelAndView withdrawServiceFromSearch()
	{
		if(account != null)
		{
			System.out.println("Account Details : " + account);
			ModelAndView mv = new ModelAndView("banking/withdraw");
			mv.addObject("account", account);
			return mv;
		}
			
			ModelAndView mv = new ModelAndView("banking/search_withdraw");
			mv.addObject("account", account);
			mv.addObject("alert", "Please Enter Account ID..!!!");
			return mv;
	}
	
	//	Process Withdraw Request
	@PostMapping("banking/account/withdraw")
	public ModelAndView processWithdrawRequest(@RequestParam("amount") String amount, @RequestParam("message") String message)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : deposit_Service");
		
		
		ModelAndView mv = new ModelAndView("banking/deposit");
		mv.addObject("account", account);
		String status = new String();
		
		if(account.getAccountType().equals(AccountType.saving))
			status = accountService.withdrawMoney(account.getAccountId(), AccountType.saving, Double.parseDouble(amount), message);
		else
			if(account.getAccountType().equals(AccountType.current))
				status = accountService.withdrawMoney(account.getAccountId(), AccountType.current, Double.parseDouble(amount), message);

		mv.addObject("alert", status);

		return mv;
	}

/************************|		TRANSFER SERVICE [PENDING]	|**********************************************************************************/	

	//	Display Search Page for Transfer Service
	@RequestMapping("banking/account/transfer/search")
	public ModelAndView transferService()
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		ModelAndView mv = new ModelAndView("banking/search_transfer");
		return mv;	
	}
	
	//	Navigate to Deposit Page via Withdraw Option
	@RequestMapping("banking/account/transfer/search/id")
	public ModelAndView navigateToTransferService(@RequestParam("id") String id)
	{
		System.out.println("[CONTROLLER] : AccountController | [FUNCTION] : depositService");

		if(id != null)
		{
			customer = customerService.getCustomerByID(id);
			
			if(customer.getCustomer_id().equalsIgnoreCase(id))
			{
				System.out.println("Account Details : " + customer);
				ModelAndView mv = new ModelAndView("banking/transfer");
				mv.addObject("customer", customer.getCustomer_id());
				
				return mv;
			}
			
			ModelAndView mv = new ModelAndView("banking/search_transfer");
			mv.addObject("alert", "Account ID is Invalied or Account is not avaiable...!!");
			return mv;
		}
			
			ModelAndView mv = new ModelAndView("banking/search_transfer");
			mv.addObject("customer", customer);
			mv.addObject("alert", "Please Enter Account ID..!!!");
			return mv;
	}
	
	//	Process Transfer Request
	@PostMapping("banking/account/transfer")
	public ModelAndView processTransferRequest(@RequestParam("amount") double amount, @RequestParam("source_account") String source,
										@RequestParam("destination_account") String destination, @RequestParam("message") String message)
	{		
		if(source.equals(destination))
		{
			ModelAndView mv = new ModelAndView("banking/transfer");
			mv.addObject("alert", "Source and Destination account are same...!!!");
			mv.addObject("customer", customer);
			return mv;
		}
		
		if(source.equalsIgnoreCase("SAVINGS"))
		{
			ModelAndView mv = new ModelAndView("banking/transfer");
			mv.addObject("customer", customer.getCustomer_id());
			mv.addObject("alert", accountService.transferMoney(customer.getCustomer_id(), AccountType.saving, AccountType.current, amount, message));
			
			return mv;
		}
		else
		{	if(source.equalsIgnoreCase("CURRENT"))
			{
				ModelAndView mv = new ModelAndView("banking/transfer");
				mv.addObject("customer", customer.getCustomer_id());
				mv.addObject("alert", accountService.transferMoney(customer.getCustomer_id(), AccountType.current, AccountType.saving, amount, message));
					
				return mv;
			}
		}
		
		ModelAndView mv = new ModelAndView("banking/transfer");
		mv.addObject("alert", "ERROR...!!!");
		mv.addObject("customer", customer);
		return mv;
	}
	
/*************************************|		VIEW ALL ACCOUNTS [COMPLETED]	|***************************************************/
	
	@RequestMapping("banking/account/search/all")
	public ModelAndView displayAllAccounts()
	{
		ModelAndView mv = new ModelAndView("banking/accounts");
		mv.addObject("accounts", accountService.getAllAccounts());
		return mv;
		
	}
	
/******************************|	TRANSACTION SERVICE [COMPLETED]	|**********************************************************/
		
	
	@RequestMapping("banking/account/transactions/all")
	public ModelAndView displayAllTransactions()
	{
		ModelAndView mv = new ModelAndView("banking/transactions");
		mv.addObject("tx", txService.getAllTransaction());
		return mv;
	}
}
