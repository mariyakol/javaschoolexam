package com.tsystems.javaschool.tasks.calculator.operations;

import java.util.ArrayDeque;

public class Subtraction extends Operation {
    @Override
    public void performOperation(ArrayDeque<Double> stack) {
        Double first = stack.pollFirst();
        Double second = stack.pollFirst();

        Double res = second - first;

        stack.addFirst(res);
    }
}
