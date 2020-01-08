package com.deloitte.telecom.dao;


import java.util.List;



import com.deloitte.telecom.entities.CustomerAccount;

public interface ICustomerAccountDao {
	 boolean checkCredentialsById(int id, String password);

	 boolean checkCredentialsByMobileNo(String mobileNo, String password);

    CustomerAccount findByMobileNo(String mobileNo);
    
    CustomerAccount findUserById(int id);

    CustomerAccount save(CustomerAccount user);
    
    List<CustomerAccount> fetchUsers(int blockSize);

    void rechargeAccount(CustomerAccount c, double amount);
}
