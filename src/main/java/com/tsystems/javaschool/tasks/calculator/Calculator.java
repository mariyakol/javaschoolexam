package com.tsystems.javaschool.tasks.calculator;

import java.util.ArrayList;

public class Calculator {
    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {
        if (statement == null || statement.isEmpty()) {
            return null;
        }

        try {
            ArrayList<String> rpnExpression = new ReversePolishNotationConverter(statement).convert();
            return new CalculatorImpl(rpnExpression).calculateResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
