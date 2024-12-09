package com.luv2code.aopdemo;

import java.util.List;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService theTrafficFortuneService) {

		return runner ->
		{
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturningAdvice(accountDAO);
			// demoTheAfterThrowingAdvice(accountDAO);
			// demoTheAfterAdvice(accountDAO);
			// demoTheAroundAdvice(theTrafficFortuneService);

			// demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};

	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("Main Program:  demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("My Fortune is: " + data);

		System.out.println("Finished!");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("Main Program:  demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("My Fortune is: " + data);

		System.out.println("Finished!");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("Main Program:  demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("My Fortune is: " + data);

		System.out.println("Finished!");

	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to stimulate exception
			boolean tripWire = false;
			theAccounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception e) {
			System.out.println("Main Program: ... caught exception: " + e);
		}

		// display the accounts
		System.out.println("Main Program: demoTheAfterRThrowingAdvice");
		System.out.println("------");
		System.out.println(theAccounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to stimulate exception
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception e) {
			System.out.println("Main Program: ... caaught exception: " + e);
		}

		// display the accounts
		System.out.println("Main Program: demoTheAfterRThrowingAdvice");
		System.out.println("------");
		System.out.println(theAccounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = accountDAO.findAccounts();

		// display the accounts
		System.out.println("Main Program: demoTheAfterReturningAdvice");
		System.out.println("------");
		System.out.println(theAccounts);

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		Account myAccount = new Account();
		myAccount.setName("John");
		myAccount.setLevel("Platform");
		accountDAO.addAccount(myAccount, true);
		accountDAO.doWork();

		// call the account getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setService("silver");

		String name = accountDAO.getName();
		String service = accountDAO.getService();

		// call the membership method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}
}
