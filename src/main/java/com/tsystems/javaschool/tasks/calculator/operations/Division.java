package com.tsystems.javaschool.tasks.calculator.operations;

import java.util.ArrayDeque;

public class Division extends Operation {
    @Override
    public void performOperation(ArrayDeque<Double> stack) {
        Double first = stack.pollFirst();
        if (first == 0) {
            throw new ArithmeticException();
        }
        Double second = stack.pollFirst();

        Double res = second / first;

        stack.addFirst(res);
    }
}
