package com.taku;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CalculatorParameterizedTest {

    @Parameter
    public String input;
    @Parameter(1)
    public double expected;
    private Calculator calculator;

    @Parameters(name = "{index}: calculator.calculate(\"{0}\") = {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"5 8 +", 13.0},
                {"5 8 + 13 -       ", 0.0},
                {"-3   -2 * 5 + ", 11.0},
                {"5 9 1 -      / ", 0.625},
                {"   .0 8 +", 8.0},
                {"2 3 +", 5.0},
                {".0 3 +", 3.0},
                {"2 .3 +", 2.3},
                {"2 3 -", -1.0},
                {"2 .3 *", 0.6},
                {"2 3 /", 0.6666666666666666},
                {".0 .0 /", Double.NaN},
                {"15 7 1 1 + - / 3 * 2 1 1 + + -", 5.0},
                {"-4 5 +", 1.0},
                {"5 1 2 + 4 * 3 - +", 14.0},
                {"4 2 5 * + 1 3 2 * + /", 2.0},
                {"1 +", Double.NaN},
                {"+", Double.NaN},
                {"test", Double.NaN},
                {"t", Double.NaN},
                {"0 -0 * ", -0.0},
                {"0 -0 - ", 0.0},
                {"-0 0 - ", -0.0},
                {"0 0 * ", 0.0},
                {"", Double.NaN},
                {"0", 0.0},
                {"2 2 3 + 1 -", 4.0}});
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testCalculatorCalculate() {
        assertThat(calculator.calculate(input), is(expected));
    }

}
