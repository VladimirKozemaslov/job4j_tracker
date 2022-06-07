package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcFunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CalcFunctions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = CalcFunctions.diapason(5, 8, x -> 3 * Math.pow(x, 2) + 4 * x + 1);
        List<Double> expected = Arrays.asList(96D, 133D, 176D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicatorFunctionThenIndicatorResults() {
        List<Double> result = CalcFunctions.diapason(2, 5, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(9D, 27D, 81D);
        assertThat(result, is(expected));
    }
}