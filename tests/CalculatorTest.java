import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by employee on 7/8/16.
 */
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void before() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void emptyStringSending() {
        assertThat(calculator.add(""), is(0));
    }

    @Test
    public void oneElementSending() {
        assertThat(calculator.add("1"), is(1));
    }

    @Test
    public void onePlusTwoAdding() {
        assertThat(calculator.add("1,2"), is(3));
    }

    @Test
    public void fiveOperandsAdding() {
        assertThat(calculator.add("1,1,1,2,2,"), is(7));
    }

    @Test
    public void addingWithTwoTypesOfDelimiters() throws Exception {
        assertThat(calculator.add("1\n2,3"),is(6));
    }

    @Test
    public void customDelimiter() throws Exception {
        assertThat(calculator.add("//s\n1s2s3"),is(6));
    }

    @Test
    public void differentDelimitersWithCustomDelimiter() throws Exception {
        assertThat(calculator.add("//s\n1s2,3\n1"), is(7));
    }
}
