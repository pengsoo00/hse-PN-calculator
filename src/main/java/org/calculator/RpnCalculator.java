package org.calculator;

import java.math.BigDecimal;
// Collections
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class RpnCalculator {
    private static final String OPERATORS = "+-*/^";
    private static final String FUNCTIONS = "sin cos tan log log10 log2";
    private static final int SCALE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<BigDecimal> stack = new ArrayDeque<>();
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (isNumber(token)) {
                stack.push(new BigDecimal(token));
            } else if (isOperator(token)) {
                BigDecimal b = stack.pop();
                BigDecimal a = stack.pop();
                stack.push(applyOperator(token, a, b));
            } else if (isFunction(token)) {
                BigDecimal a = stack.pop();
                stack.push(applyFunction(token, a));
            } else if (token.equals("q")) {
                break;
            } else {
                System.err.println("Unknown token: " + token);
            }
            System.out.println(stack);
        }
    }

    static boolean isNumber(String token) {
        try {
            new BigDecimal(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    static boolean isFunction(String token) {
        return FUNCTIONS.contains(token);
    }

    static BigDecimal applyOperator(String operator, BigDecimal a, BigDecimal b) {
        BinaryOperator<BigDecimal> op;
        switch (operator) {
            case "+":
                op = BigDecimal::add;
                break;
            case "-":
                op = BigDecimal::subtract;
                break;
            case "*":
                op = BigDecimal::multiply;
                break;
            case "/":
                op = (x, y) -> x.divide(y, SCALE, BigDecimal.ROUND_HALF_UP);
                break;
            case "^":
                op = (x, y) -> x.pow(y.intValue());
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
        return op.apply(a, b);
    }

    static BigDecimal applyFunction(String function, BigDecimal a) {
        UnaryOperator<BigDecimal> op;
        switch (function) {
            case "sin":
                op = x -> BigDecimal.valueOf(Math.sin(x.doubleValue()));
                break;
            case "cos":
                op = x -> BigDecimal.valueOf(Math.cos(x.doubleValue()));
                break;
            case "tan":
                op = x -> BigDecimal.valueOf(Math.tan(x.doubleValue()));
                break;
            case "log":
                op = x -> BigDecimal.valueOf(Math.log(x.doubleValue()));
                break;
            case "log10":
                op = x -> BigDecimal.valueOf(Math.log10(x.doubleValue()));
                break;
            case "log2":
                op = x -> BigDecimal.valueOf(Math.log(x.doubleValue()) / Math.log(2));
                break;
            default:
                throw new IllegalArgumentException("Unknown function: " + function);
        }
        return op.apply(a);
    }
}
