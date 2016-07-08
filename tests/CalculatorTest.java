import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by employee on 7/8/16.
 */
public class CalculatorTest {


    @Test
    public void onePlusTwo(){
        Calculator calculator = new Calculator();
        assertThat(calculator.add(""), is(0));
    }
}
