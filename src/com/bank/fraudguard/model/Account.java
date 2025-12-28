package com.bank.fraudguard.model;

public class Account {
    private String accountNumber;
    private double balance;
    
    private String homeCountry;       
    private boolean isLocked;        
    private String currentOtp;     
    private long otpExpiryTime;       

    public Account(String accountNumber, double balance, String homeCountry) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.homeCountry = homeCountry;
        this.isLocked = false; 
    }

    public String getAccountNumber() { return accountNumber; }
    
    public double getBalance() { return balance; }
    
    public void setBalance(double balance) { this.balance = balance; }

    public String getHomeCountry() { return homeCountry; }

    public boolean isLocked() { return isLocked; }

    public void setLocked(boolean locked) { isLocked = locked; }

    public String getCurrentOtp() { return currentOtp; }

    public void setCurrentOtp(String currentOtp) { this.currentOtp = currentOtp; }

    public long getOtpExpiryTime() { return otpExpiryTime; }

    public void setOtpExpiryTime(long otpExpiryTime) { this.otpExpiryTime = otpExpiryTime; }
}
