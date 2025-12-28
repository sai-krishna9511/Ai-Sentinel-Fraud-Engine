package com.bank.fraudguard.config;

import com.bank.fraudguard.ai.BehavioralSentinel;
import com.bank.fraudguard.model.Account;
import com.bank.fraudguard.model.Transaction;
import java.util.Scanner;

public class ProjectLauncher {
    public static void main(String[] args) {
        String datasetPath = "C:\\Users\\dattu\\Downloads\\archive (2)\\bank_transactions.csv";
        
        BehavioralSentinel sentinel = new BehavioralSentinel();
        // Train the brain before starting
        sentinel.trainFromKaggle(datasetPath);

        Account myAccount = new Account("ACC_DATTU", 10000.0, "India");
        Transaction testTx = new Transaction("T1", "ACC_DATTU", 500.0, "London");

        try {
            sentinel.analyzeTransaction(myAccount, testTx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // OTP verification logic here...
        }
    }
}