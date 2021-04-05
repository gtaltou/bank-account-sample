package com.taltou.operation;

import com.taltou.amount.Amount;

import java.util.Date;

public class OperationHelper {

    private Date date;
    private Amount value;

    public static OperationHelper aTransaction() {
        return new OperationHelper();
    }

    public OperationHelper with(Date date) {
        this.date = date;
        return this;
    }

    public OperationHelper with(Amount value) {
        this.value = value;
        return this;
    }

    public Operation build() {
        Operation operation = new Operation(value, date);
        return operation;
    }
}
