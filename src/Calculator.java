/**
 * Created by employee on 7/8/16.
 */
public class Calculator {
    private static final int DELIMITER_INDEX = 2;
    private int result;
    private String delimiters = ",|\n";

    private String[] prepareOperands(String mathExpression){
        if (mathExpression.startsWith("//")) {
            mathExpression = mathExpression.substring(DELIMITER_INDEX+1); // delete "//"
            delimiters += "|" + String.valueOf(mathExpression.charAt(DELIMITER_INDEX));
            return mathExpression.substring(mathExpression.indexOf("\n")+1).split(delimiters);
        }else {
            return mathExpression.split(delimiters);
        }
    }



    private void checkForNegatives(String[] operandsArray) {
        String negativeNumbers = "";
        boolean isNegative = false;
        for (String operand:operandsArray){
            if (Integer.parseInt(operand) < 0) {
                negativeNumbers += Integer.parseInt(operand) + " ";
                isNegative = true;
            }
        }

        if (isNegative){
            throw new RuntimeException("Negatives not allowed. Wrong numbers: " + negativeNumbers);
        }
    }


    public int add(String mathExpression) {
        if (mathExpression.isEmpty())
            return 0;

        String[] operandsArray = prepareOperands(mathExpression);
        checkForNegatives(operandsArray);

        for (String operand : operandsArray) {
            result += Integer.parseInt(operand);
        }
        return result;
    }
}
