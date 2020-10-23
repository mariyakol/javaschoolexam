package com.tsystems.javaschool.tasks.calculator.operations;

import java.util.ArrayDeque;

public class Multiplication extends Operation{
    @Override
    public void performOperation(ArrayDeque<Double> stack) {
        Double first = stack.pollFirst();
        Double second = stack.pollFirst();

        Double res = first * second;

        stack.addFirst(res);
    }
}
