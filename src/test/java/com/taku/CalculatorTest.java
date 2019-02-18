package com.taku;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUpToHexStringData() {
        calculator = new Calculator();
    }

    @Test
    public void calculateSum() {
        assertThat(calculator.calculate("2"), is(2.0));
        assertThat(calculator.calculate("3"), is(3.0));
        assertThat(calculator.calculate("+"), is(5.0));
    }

    @Test
    public void calculateInvalidSum() {
        assertThat(calculator.calculate("-2"), is(-2.0));
        assertThat(calculator.calculate("0"), is(0.0));
        assertThat(calculator.calculate("+"), is(not(2.0)));
    }

    @Test
    public void calculateMinus() {
        assertThat(calculator.calculate("5"), is(5.0));
        assertThat(calculator.calculate("3"), is(3.0));
        assertThat(calculator.calculate("-"), is(2.0));
    }

    @Test
    public void calculateInvalidMinus() {
        assertThat(calculator.calculate("0"), is(0.0));
        assertThat(calculator.calculate("0"), is(0.0));
        assertThat(calculator.calculate("-"), is(not(Double.NaN)));
    }

    @Test
    public void calculateTwoDots() {
        assertThat(calculator.calculate("1.2.3"), is(Double.NaN));
    }

    @Test
    public void calculateDivideOnZero() {
        assertThat(calculator.calculate("1"), is(1.0));
        assertThat(calculator.calculate("0 /"), is(Double.POSITIVE_INFINITY));
        assertThat(calculator.calculate("r"), is(Double.NaN));
        assertThat(calculator.calculate("-1 0 /"), is(Double.NEGATIVE_INFINITY));
        assertThat(calculator.calculate("r"), is(Double.NaN));
        assertThat(calculator.calculate("1 -0 /"), is(Double.NEGATIVE_INFINITY));
        assertThat(calculator.calculate("r"), is(Double.NaN));
        assertThat(calculator.calculate("-1 -0 /"), is(Double.POSITIVE_INFINITY));
    }

    @Test
    public void calculateZeroDivideOnNumber() {
        assertThat(calculator.calculate("0"), is(0.0));
        assertThat(calculator.calculate("1"), is(1.0));
        assertThat(calculator.calculate(" /   "), is(0.0));
    }

    @Test
    public void calculateValues() {
        assertThat(calculator.calculate("5 9 1 - /"), is(0.625));
        assertThat(calculator.calculate("r"), is(Double.NaN));
        assertThat(calculator.calculate("100 100 * 100 * 100 * 100 * 1000 *"), is(1.0E13));
        assertThat(calculator.calculate("r"), is(Double.NaN));
        assertThat(calculator.calculate("100 100 * 100 * "), is(1000000.0));
    }

}