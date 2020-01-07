package com.deloitte.telcom.service;


import com.deloitte.telcom.entities.CustomerAccount;

public interface ICustomerAccountService {
    boolean credentialsCorrect(String mobileNo, String password);

    CustomerAccount findByMobileNo(String mobileNo);

    CustomerAccount save(CustomerAccount user);
}
