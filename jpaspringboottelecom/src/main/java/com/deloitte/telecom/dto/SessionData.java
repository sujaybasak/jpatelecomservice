package com.deloitte.telecom.dto;

import com.deloitte.telecom.entities.*;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData {

    private CustomerAccount user;

    public void setUser(CustomerAccount user){
        this.user=user;
    }

    public CustomerAccount getUser(){
        return user;
    }




}
