package com.deloitte.telcom.dto;

import com.deloitte.telcom.entities.CustomerAccount;

import org.springframework.stereotype.Component;

public class SessionData {

    private CustomerAccount user;

    public void setUser(CustomerAccount user){
        this.user=user;
    }

    public CustomerAccount getUser(){
        return user;
    }




}
