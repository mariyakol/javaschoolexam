package com.tsystems.javaschool.tasks.calculator.operations;

import java.util.ArrayDeque;

public abstract class Operation {
    public abstract void performOperation(ArrayDeque<Double> stack);
}
