package com.taltou.error;

public class InsufficientFundException extends Exception {
    public InsufficientFundException() {
        super("operation refused, insufficient fund.");
    }
}
