package com.luv2code.aopdemo.dao;


import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    // add a new method findAccounts()

    List<Account> findAccounts();

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getService();

    void setService(String service);


    List<Account> findAccounts(boolean tripWire);
}
