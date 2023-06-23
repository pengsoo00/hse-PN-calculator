package org.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class RpnCalculatorTest {

    @DisplayName("Add two numbers")
    @Test
    void testAddition() {
        // given
        BigDecimal a = new BigDecimal("2");
        BigDecimal b = new BigDecimal("3");
        BigDecimal expected = new BigDecimal("5");

        // when
        BigDecimal actual = org.calculator.RpnCalculator.applyOperator("+", a, b);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("Subtract two numbers")
    @Test
    void testSubtraction() {
        // given
        BigDecimal a = new BigDecimal("5");
        BigDecimal b = new BigDecimal("3");
        BigDecimal expected = new BigDecimal("2");

        // when
        BigDecimal actual = org.calculator.RpnCalculator.applyOperator("-", a, b);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("Multiply two numbers")
    @Test
    void testMultiply() {
        // given
        BigDecimal a = new BigDecimal("2");
        BigDecimal b = new BigDecimal("3");
        BigDecimal expected = new BigDecimal("6");

        // when
        BigDecimal actual = org.calculator.RpnCalculator.applyOperator("*", a, b);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("Division two numbers")
    @Test
    void testDivision() {
        // given
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("2");
        BigDecimal expected = new BigDecimal("5.0000000000");

        // when
        BigDecimal actual = org.calculator.RpnCalculator.applyOperator("/", a, b);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("Power")
    @Test
    void testPower() {
        // given
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("2");
        BigDecimal expected = new BigDecimal("100");

        // when
        BigDecimal actual = org.calculator.RpnCalculator.applyOperator("^", a, b);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("Sin")
    @Test
    void testSinFunction() {
        //given
        BigDecimal a = new BigDecimal("30");
        BigDecimal expected = new BigDecimal("-0.9880316240928618");

        //when
        BigDecimal actual = org.calculator.RpnCalculator.applyFunction("sin", a);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("Cos")
    @Test
    void testCosFunction() {
        //given
        BigDecimal a = new BigDecimal("1");
        BigDecimal expected = new BigDecimal("0.5403023058681398");

        //when
        BigDecimal actual = org.calculator.RpnCalculator.applyFunction("cos", a);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("Tan")
    @Test
    void testTanFunction() {
        //given
        BigDecimal a = new BigDecimal("30");
        BigDecimal expected = new BigDecimal("-6.405331196646276");

        //when
        BigDecimal actual = org.calculator.RpnCalculator.applyFunction("tan", a);

        //then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Log")
    void testLogFunction() {
        // given
        BigDecimal a = new BigDecimal("100");
        BigDecimal expected = new BigDecimal("4.605170186");

        // when
        BigDecimal actual = org.calculator.RpnCalculator.applyFunction("log", a);

        // then
        assertEquals(expected, actual.setScale(9, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Log2")
    void testLog2Function() {
        // given
        BigDecimal a = new BigDecimal("16");
        BigDecimal expected = new BigDecimal("4.000000000");

        // when
        BigDecimal actual = org.calculator.RpnCalculator.applyFunction("log2", a);

        // then
        assertEquals(expected, actual.setScale(9, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Log10")
    void testLog10Function() {
        // given
        BigDecimal a = new BigDecimal("100");
        BigDecimal expected = new BigDecimal("2.000000000");

        // when
        BigDecimal actual = org.calculator.RpnCalculator.applyFunction("log10", a);

        // then
        assertEquals(expected, actual.setScale(9, RoundingMode.HALF_UP));
    }

    @DisplayName("UnknownToken")
    @Test()
    void testUnknownToken() {
        String token = "100";
        assertTrue(org.calculator.RpnCalculator.isNumber(token));
        assertFalse(org.calculator.RpnCalculator.isOperator(token));
        assertFalse(org.calculator.RpnCalculator.isFunction(token));

        token = "+";
        assertFalse(org.calculator.RpnCalculator.isNumber(token));
        assertTrue(org.calculator.RpnCalculator.isOperator(token));
        assertFalse(org.calculator.RpnCalculator.isFunction(token));

        token = "cos";
        assertFalse(org.calculator.RpnCalculator.isNumber(token));
        assertFalse(org.calculator.RpnCalculator.isOperator(token));
        assertTrue(org.calculator.RpnCalculator.isFunction(token));

        token = "Unknown";
        assertFalse(org.calculator.RpnCalculator.isNumber(token));
        assertFalse(org.calculator.RpnCalculator.isOperator(token));
        assertFalse(org.calculator.RpnCalculator.isFunction(token));
    }
}
