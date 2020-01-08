package com.deloitte.telecom.controller;

import com.deloitte.telecom.dto.SessionData;

import com.deloitte.telecom.exceptions.IncorrectMobileNoException;
import com.deloitte.telecom.service.ICustomerAccountService;
import com.deloitte.telecom.entities.CustomerAccount;
import com.deloitte.telecom.exceptions.MobileNoAlreadyExistsException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {
	 private static Logger Log= LoggerFactory.getLogger(HelloController.class);
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
    public Object loginCheck(@RequestParam("mobileno") String mobileNo,
                                   @RequestParam("password") String password) {

        boolean correct = service.checkCredentialsByMobileNo(mobileNo, password);
        if (!correct) {
            return new ModelAndView("userinput","message","Incorrect mobile number or password.");
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
        user.setMobileNo(mobileNo);
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

    @GetMapping("/recharge")
    public ModelAndView recharge(@RequestParam("amount") double balance) {
        CustomerAccount appUser = sessionData.getUser();
        service.rechargeAccount(appUser, balance);
        return new ModelAndView("home","user",appUser);
    }
    
    @GetMapping("/error")
    public ModelAndView error(){
        return new ModelAndView("error","message","something went wrong");
    }

    @ExceptionHandler(MobileNoAlreadyExistsException.class)
    public ModelAndView handleIfMobileNumberAlreadyExists(MobileNoAlreadyExistsException e){
      return new ModelAndView("register","message","mobilenumber already exists");
    }

    @ExceptionHandler(IncorrectMobileNoException.class)
    public ModelAndView handleIfIncorrectMobileNo(IncorrectMobileNoException e){
        return new ModelAndView("register","message","Please enter valid mobile number.");
    }

    @ExceptionHandler(value = Throwable.class)
    public ModelAndView catchAll(Throwable e){
        e.printStackTrace();
      return new ModelAndView("error","message","Something went wrong");
    }


}
