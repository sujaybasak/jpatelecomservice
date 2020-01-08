package com.deloitte.telecom.dao;

import com.deloitte.telecom.entities.CustomerAccount;
import com.deloitte.telecom.exceptions.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
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
    public boolean checkCredentialsById(int id, String password) {
        CustomerAccount user = entityManager.find(CustomerAccount.class, id);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }


    @Override
    public boolean checkCredentialsByMobileNo(String mobileNo, String password) {
        CustomerAccount user = findByMobileNo(mobileNo);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public CustomerAccount findUserById(int id) {
        CustomerAccount user = entityManager.find(CustomerAccount.class, id);
        return user;
    }

    @Override
    public CustomerAccount findByMobileNo(String mobileNo) {
        try {
            String jql = "from CustomerAccount where mobileNo=:mob";
            TypedQuery<CustomerAccount> query = entityManager.createQuery(jql, CustomerAccount.class);
            query.setParameter("mob", mobileNo);
            CustomerAccount result = query.getSingleResult();
            return result;
        }catch (NoResultException e){
            return null;
        }
    }


    @Override
    public List<CustomerAccount> fetchUsers(int blockSize) {
        String jql = "from CustomerAccount";
        TypedQuery<CustomerAccount> query = entityManager.createQuery(jql, CustomerAccount.class);
        query.setMaxResults(blockSize);
        List<CustomerAccount> list = query.getResultList();
        return list;
    }


    public boolean mobileNumberExists(String mobileNo) {
        CustomerAccount user = findByMobileNo(mobileNo);
        return user != null;
    }

    @Override
    public CustomerAccount save(CustomerAccount user) {
        System.out.println("inside save,user=" + user);
        String phone = user.getMobileNo();
        boolean exists = mobileNumberExists(phone);
        if (exists) {
        	 throw new MobileNoAlreadyExistsException("mobile no exists");
        }
        user = getEntityManager().merge(user);
        return user;
    }

    @Override
    public void rechargeAccount(CustomerAccount c, double amount) {
        c.addBalance(amount);
    }
}
