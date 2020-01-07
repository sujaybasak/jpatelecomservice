package com.deloitte.telcom.dao;

import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.entities.CustomerAccount;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerAccountDaoImpl implements ICustomerAccountDao {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public boolean credentialsCorrect(String mobileNo, String password) {
        CustomerAccount user = entityManager.find(CustomerAccount.class, mobileNo);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public CustomerAccount findByMobileNo(String mobileNo) {
        CustomerAccount user = entityManager.find(CustomerAccount.class, mobileNo);
        return user;
    }



    @Override
    public CustomerAccount save(CustomerAccount user) {
        user = getEntityManager().merge(user);
        return user;
    }
}
