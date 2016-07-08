/**
 * Created by employee on 7/8/16.
 */
public class Calculator {
    int result;

    public int add(String mathExpression) {
        if (mathExpression.isEmpty())
            return 0;

        String[] operandsArray = mathExpression.split(",");
        for (String operand : operandsArray) {
            result += Integer.parseInt(operand);
        }
        return result;
    }
}
