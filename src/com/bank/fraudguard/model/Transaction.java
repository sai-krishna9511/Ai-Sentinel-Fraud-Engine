package com.bank.fraudguard.model;
import java.time.LocalDateTime;
public class Transaction {
    private String transactionId;
    private String accountNumber;
    private double amount;
    
    
    private String country;           
    private LocalDateTime timestamp;  

   
    public Transaction(String transactionId, String accountNumber, double amount, String country) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.country = country;
        this.timestamp = LocalDateTime.now();
    }

  
    public String getTransactionId() { return transactionId; }
    public String getAccountNumber() { return accountNumber; }
    public double getAmount() { return amount; }
    public String getCountry() { return country; }
    public LocalDateTime getTimestamp() { return timestamp; }
}