package com.bank.fraudguard.service;

import com.bank.fraudguard.model.Account;
import java.util.Random;
import java.util.concurrent.*;

/**
 * ARCHITECT NOTE: This service handles the 'Adaptive Challenge'.
 * It generates a 6-digit OTP and starts a 60-second background timer.
 */
public class OtpService {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Random random = new Random();

    public String generateOtp(Account account) {
       
        String otp = String.format("%06d", random.nextInt(999999));
        account.setCurrentOtp(otp);
        
        
        account.setOtpExpiryTime(System.currentTimeMillis() + 60000);
        
        System.out.println("[OTP SERVICE] ALERT: OTP sent to user: " + otp);
        
        
        startExpiryTimer(account);
        
        return otp;
    }

    private void startExpiryTimer(Account account) {
        scheduler.schedule(() -> {
            if (account.getCurrentOtp() != null) {
                account.setLocked(true);
                account.setCurrentOtp(null); 
                System.err.println("[SECURITY] ALERT: OTP Expired. Account " + 
                                   account.getAccountNumber() + " is now LOCKED.");
            }
        }, 1, TimeUnit.MINUTES);
    }
}