package com.taltou.amount;

import com.taltou.helpers.Helper;

import java.util.Objects;


public class Amount {



    private final int input;

    /**
     * Constructor that initializes the instance value with the input value
     * @param input the input value
     */
    public Amount(int input) {
        this.input = input;
    }

    /**
     * New amount
     * @param input the input value
     * @return  the return value
     */
    public static Amount newAmount(int input) {
        return new Amount(input);
    }

    /**
     * Add up amounts
     * @param otherAmount: Other amount
     * @return the retun value
     */
    public Amount addUp(Amount otherAmount) {
        return newAmount(this.input + otherAmount.input);
    }

    /**
     * Compare amounts
     * @param otherAmount : Other amount
     * @return the return value
     */
    public boolean isGreaterThan(Amount otherAmount) {
        return this.input > otherAmount.input;
    }

    /**
     * return the absolute value
     * @return : The return value
     */
    public Amount absoluteValue() {
        return newAmount(Math.abs(input));
    }

    /**
     * Return the money format
     * @return : The return value
     */
    public String computeMoneyFormat() {
        return Helper.decimalFormat.format(input);
    }

    /**
     * @return the return value
     */
    public Amount subtract() {
        return newAmount(-input);
    }

    /**
     * @param o : The object
     * @return : The return value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return input == amount.input;
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "input=" + input +
                '}';
    }
}
