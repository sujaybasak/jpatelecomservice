package com.deloitte.telcom.controller;

import com.deloitte.telcom.dto.SessionData;

import com.deloitte.telcom.service.ICustomerAccountService;
import com.deloitte.telcom.entities.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {

    private ICustomerAccountService service;

    public ICustomerAccountService getService() {
        return service;
    }

    @Autowired
    public void setService(ICustomerAccountService service) {
        this.service = service;
    }

    private SessionData sessionData;

    @Autowired
    public void setSessionData(SessionData data) {
        this.sessionData = data;

    }

    public SessionData getSessionData() {
        return sessionData;
    }


    @GetMapping("/userinput")
    public ModelAndView userInput() {
        System.out.println("inside userinput");
        return new ModelAndView("userinput");
    }

    @GetMapping("/logincheck")
    public RedirectView loginCheck(@RequestParam("mobileno") String mobileNo,
                                   @RequestParam("password") String password) {

        boolean correct = service.credentialsCorrect(mobileNo, password);
        if (!correct) {
            return new RedirectView("/userinput");
        }
        CustomerAccount user = service.findByMobileNo(mobileNo);
        sessionData.setUser(user);
        return new RedirectView("/home");
    }


    @GetMapping("/home")
    public Object home() {
        if (sessionData.getUser() == null) {
            return new RedirectView("/userinput");
        }
        CustomerAccount appUser = sessionData.getUser();
        ModelAndView mv = new ModelAndView("home", "user", appUser);
        return mv;
    }


    @GetMapping("/processregister")
    public RedirectView processRegister(@RequestParam("mobileno") String mobileNo,@RequestParam("name") String name,
                                        @RequestParam("accounttype") String accountType,@RequestParam("recharge") double balance,
                                 @RequestParam("password") String password) {
        CustomerAccount user = new CustomerAccount(mobileNo,name,accountType,balance,password);
        System.out.println("mobile" +user.getMobileNo());



        user=service.save(user);
        sessionData.setUser(user);
        return new RedirectView("/home");
    }

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("/register");
    }

    @GetMapping("/signout")
    public RedirectView signout(){
        sessionData.setUser(null);
        return new RedirectView("/userinput");
    }

}
