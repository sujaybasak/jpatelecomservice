package com.deloitte.telecom.entities;

import javax.persistence.*;

@Entity
@Table(name = "telcomusers")
public class CustomerAccount {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private int id;
	 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(unique =true)
    private String mobileNo;
    private String name;
    private String accountType;
    private double balance;
    private String password;

    public CustomerAccount(){}

    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public CustomerAccount(String mobileNo, String name, String accountType, double balance, String password) {
        this.mobileNo = mobileNo;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.password = password;
    }
}
