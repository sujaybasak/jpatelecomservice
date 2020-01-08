package com.deloitte.telecom.service;

import com.deloitte.telecom.dao.ICustomerAccountDao;

import com.deloitte.telecom.entities.CustomerAccount;

import java.util.List;


import com.deloitte.telecom.exceptions.IncorrectMobileNoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerAccountServiceImpl implements ICustomerAccountService{

    private ICustomerAccountDao userDao;

    public ICustomerAccountDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(ICustomerAccountDao dao) {
        this.userDao = dao;
    }

    @Override
    public boolean checkCredentialsById(int id, String password) {
        return userDao.checkCredentialsById(id, password);
    }


    @Override
    public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
        return userDao.checkCredentialsByMobileNo(mobileNo, password);
    }


    @Override
    public CustomerAccount findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public CustomerAccount save(CustomerAccount user) {
        String phone=user.getMobileNo();
        if(phone==null || phone.length()!=10) {
            throw new IncorrectMobileNoException("Incorrect mobile number");
        }
        return userDao.save(user);
    }

    @Override
    public CustomerAccount findByMobileNo(String mobileNo) {
        CustomerAccount user = userDao.findByMobileNo(mobileNo);
        return user;
    }

    @Override
    public List<CustomerAccount> fetchUsers(int blockSize) {
        List<CustomerAccount> users = userDao.fetchUsers(blockSize);
        return users;
    }
    @Override
    public void rechargeAccount(CustomerAccount c, double amount) {
        userDao.rechargeAccount(c, amount);
    }

    /*
    @PostConstruct
    public void init(){
       AppUser user1=new AppUser("satya","satya");
       userDao.save(user1);
       AppUser user2=new AppUser("pranav","pranav");
       userDao.save(user2);
    }*/
}
