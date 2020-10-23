package com.tsystems.javaschool.tasks.calculator;

import com.tsystems.javaschool.tasks.calculator.operations.Addition;
import com.tsystems.javaschool.tasks.calculator.operations.Division;
import com.tsystems.javaschool.tasks.calculator.operations.Multiplication;
import com.tsystems.javaschool.tasks.calculator.operations.Operation;
import com.tsystems.javaschool.tasks.calculator.operations.Subtraction;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class CalculatorImpl {
    private ArrayDeque<Double> numbersStack = new ArrayDeque<>();
    private ArrayList<String> rpnExpression;

    CalculatorImpl(ArrayList<String> rpnExpression) {
        this.rpnExpression = rpnExpression;
    }

    public String calculateResult() {
        for (String entry : rpnExpression) {
            processEntry(entry);
        }

        Double result = numbersStack.pollFirst();
        return getStringResult(result);
    }

    private void processEntry(final String entry) {
        try {
            Double number = Double.parseDouble(entry);
            numbersStack.addFirst(number);
        } catch (IllegalArgumentException e) {
            processOperation(entry);
        }
    }

    private void processOperation(final String entry) {
        Operation operation = getOperation(entry);
        operation.performOperation(numbersStack);
    }

    private static Operation getOperation(final String entry) {
        switch (entry) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static String getStringResult(Double result) {
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(4);

        return result % 1 == 0
                ? Integer.toString(result.intValue())
                : f.format(result).replace(',', '.');
    }
}
