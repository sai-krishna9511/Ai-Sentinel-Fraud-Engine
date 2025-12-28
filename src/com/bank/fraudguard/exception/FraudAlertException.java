package com.bank.fraudguard.exception;

/**
 * ARCHITECT NOTE: We added 'serialVersionUID' to ensure our AI alerts 
 * are recognized across different banking servers.
 */
public class FraudAlertException extends Exception {
    
    // THE FIX: Add this unique version ID
    private static final long serialVersionUID = 1L;

    public FraudAlertException(String message) {
        super(message);
    }
}