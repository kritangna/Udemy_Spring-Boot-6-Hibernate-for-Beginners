package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String service;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire)
        {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<Account>();

        // create sample account
        Account tempAccount1 = new Account("John", "Silver");
        Account tempAccount2 = new Account("Madhu", "Platinum");
        Account tempAccount3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(tempAccount1);
        myAccounts.add(tempAccount2);
        myAccounts.add(tempAccount3);

        return  myAccounts;
    }
    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": Doing my DB Work: Adding an Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " : getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName()");
        this.name = name;
    }

    public String getService() {
        System.out.println(getClass() + " : getService()");
        return service;
    }

    public void setService(String service) {
        System.out.println(getClass() + " : setService()");
        this.service = service;
    }
}
