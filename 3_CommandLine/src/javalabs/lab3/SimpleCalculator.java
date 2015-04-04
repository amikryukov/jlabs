package javalabs.lab3;

public class SimpleCalculator {

    private final static String HOW_TO_USE =
            "ERROR. Provide parameters as {Operand} {Operation} {Operand}.\n" +
            "Operand can be integer or float.\n" +
            "Available operations are '+', '-', '*', '/'";

    public static void main(String[] args) {
        // check input
        try {
            if (args.length != 3) {
                // number of arguments should be equal to 3
                throw new IllegalArgumentException();
            }

            Double firstOperand = Double.valueOf(args[0]);
            String operationString = args[1];
            Double secondOperand = Double.valueOf(args[2]);

            String result;
            switch(operationString) {
                case "+" :
                    result = "Summ = " + (firstOperand + secondOperand);
                    break;
                case "-" :
                    result = "Difference = " + (firstOperand - secondOperand);
                    break;
                case "*" :
                    result = "Multiplication = " + (firstOperand * secondOperand);
                    break;
                case "/" :
                    result = "Quotient = " + (firstOperand / secondOperand);
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println(HOW_TO_USE);
        }
    }
}
