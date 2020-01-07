package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.ICustomerAccountDao;

import com.deloitte.telcom.entities.CustomerAccount;
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
    public boolean credentialsCorrect(String mobileNo, String password) {
        return userDao.credentialsCorrect(mobileNo, password);
    }

    @Override
    public CustomerAccount findByMobileNo(String mobileNo) {
        return userDao.findByMobileNo(mobileNo);
    }

    @Override
    public CustomerAccount save(CustomerAccount user) {
        return getUserDao().save(user);
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
