package com.tsystems.javaschool.tasks.calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ReversePolishNotationConverter {
    private ArrayList<String> rpnExpression = new ArrayList<>();
    private ArrayDeque<Character> stack = new ArrayDeque<>();
    private String statement;

    ReversePolishNotationConverter(final String statement) {
        this.statement = statement;
    }

    public ArrayList<String> convert() {
        boolean isNumber = false;
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < statement.length(); i++) {
            char currentSymbol = statement.charAt(i);
            if (currentSymbol == ',') {
                throw new IllegalArgumentException();
            }

            if (Character.isDigit(currentSymbol) || currentSymbol == '.') {
                isNumber = true;
                number.append(currentSymbol);
                continue;
            } else if (isNumber) {
                isNumber = false;
                rpnExpression.add(number.toString());
                number.setLength(0);
            }

            switch (currentSymbol) {
                case '(':
                    stack.addFirst(currentSymbol);
                    break;
                case ')':
                    processClosingParenthesis();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    processOperation(i, currentSymbol);
                    break;
            }
        }

        if (isNumber) {
            rpnExpression.add(number.toString());
        }

        while (!stack.isEmpty()) {
            rpnExpression.add(stack.pollFirst().toString());
        }

        return rpnExpression;
    }

    private void processClosingParenthesis() {
        char stackHead;
        while ((stackHead = stack.getFirst()) != '(') {
            stack.pollFirst();
            rpnExpression.add(Character.toString(stackHead));
        }

        stack.pollFirst();
    }

    private void processOperation(final int i, final Character currentSymbol) {
        if (Character.isDigit(statement.charAt(i + 1)) || statement.charAt(i + 1) == '(') {
            while (!stack.isEmpty()) {
                char ch = stack.getFirst();

                if (!(ch == '+' || ch == '-' || ch == '*' || ch == '/')
                        || !(getPriority(ch) >= getPriority(currentSymbol))) {
                    break;
                }

                rpnExpression.add(stack.pollFirst().toString());
            }
            stack.addFirst(currentSymbol);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static int getPriority(final char operation) {
        switch (operation) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                throw new IllegalArgumentException();
        }
    }
}
