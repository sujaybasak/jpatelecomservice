package com.deloitte.telcom.dao;


import com.deloitte.telcom.entities.CustomerAccount;

public interface ICustomerAccountDao {
    boolean credentialsCorrect(String mobileNo, String password);

    CustomerAccount findByMobileNo(String mobileNo);

    CustomerAccount save(CustomerAccount user);
}
