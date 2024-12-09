package com.luv2code.aopdemo.aspect;


import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.aspectj.lang.Signature;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
    {

        // print out method we are advising on

        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("=====>>> Executing @Around to method: " + method);


        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception e) {

            // log the exception
            System.out.println(e.getMessage());

            // rethrow the exception
            throw e;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end-begin;
        System.out.println("====>>> Duration: " + duration/1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

        // print method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=====>>> Executing @After to method: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "e")
    public void afterThrowingAccountsAdvice(JoinPoint joinPoint, Throwable e)
    {
        // print method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=====>>> Executing @AfterThrowing to method: " + method);

        // log thr exception
        System.out.println("=====>>> The exception is: " + e);
    }

    // add new advice for @AfterReturning on the findAccounts
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")

    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result)
    {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=====>>> Executing @AfterReturning to method: " + method);

        // print out the result of the method
        System.out.println("=====>>> result: " + result);

        // let's post-process the data ... let's modify it :-)

        // convert the account name to uppercase
        convertAccountNAmeToUppercase(result);

        System.out.println("=====>>> result after modifying: " + result);
    }

    private void convertAccountNAmeToUppercase(List<Account> result) {
        // loop through the accounts

        for(Account account : result) {
            // get uppercase version of name
            String theUpperName = account.getName().toUpperCase();

            // update the nae on the account
            account.setName(theUpperName);
        }
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("=====>>>> Executing @Before advice on addAccount");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method args

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through the args
        for(Object arg : args) {
            System.out.println("arg: " + arg);

            if(arg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }
}
