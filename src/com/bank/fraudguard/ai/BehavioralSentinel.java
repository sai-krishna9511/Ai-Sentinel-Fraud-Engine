package com.bank.fraudguard.ai;

import com.bank.fraudguard.model.Account;
import com.bank.fraudguard.model.Transaction;
import com.bank.fraudguard.service.OtpService;
import com.bank.fraudguard.exception.FraudAlertException;
import java.io.*;
import java.util.*;

public class BehavioralSentinel {
    private OtpService otpService = new OtpService();
    private Set<String> knownSafeCountries = new HashSet<>();
    private double averageTransactionAmount = 0.0;

    // AI TRAINING: Learning from the Kaggle Dataset
    public void trainFromKaggle(String filePath) {
        int count = 0;
        double sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip Header
            // We read only the first 5000 rows to save your 8GB RAM
            while ((line = br.readLine()) != null && count < 5000) {
                String[] data = line.split(",");
                // Assuming CSV columns: ... CustomerID, TransactionAmount, Location ...
                if (data.length > 5) {
                    sum += Double.parseDouble(data[8]); // Example: TransactionAmount is index 8
                    knownSafeCountries.add(data[4]);    // Example: Location is index 4
                    count++;
                }
            }
            this.averageTransactionAmount = sum / count;
            System.out.println("[AI BRAIN] Training Complete. Learned from " + count + " real banking records.");
        } catch (Exception e) {
            System.err.println("[AI ERROR] Failed to load Kaggle data: " + e.getMessage());
        }
    }

    public void analyzeTransaction(Account account, Transaction transaction) throws FraudAlertException {
        // AI LOGIC: Behavioral Anomaly Detection
        boolean isUnusualAmount = transaction.getAmount() > (averageTransactionAmount * 10);
        boolean isNewCountry = !account.getHomeCountry().equalsIgnoreCase(transaction.getCountry());

        if (isNewCountry || isUnusualAmount) {
            System.err.println("[AI SENTINEL] ALERT: Behavioral Anomaly Detected!");
            otpService.generateOtp(account);
            throw new FraudAlertException("Security Challenge: Unusual pattern detected based on AI history.");
        }
        System.out.println("[AI SENTINEL] Transaction matches behavioral baseline. Approved.");
    }
}