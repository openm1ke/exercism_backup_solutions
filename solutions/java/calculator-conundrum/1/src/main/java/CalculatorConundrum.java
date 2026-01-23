class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) throws IllegalOperationException {
        if(operand2 == 0 && operation.equals("/")) throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());

        return switch (operation) {
            case "+" -> operand1 + " + " + operand2 + " = " + (operand1 + operand2);
            case "*" -> operand1 + " * " + operand2 + " = " + (operand1 * operand2);
            case "/" -> operand1 + " / " + operand2 + " = " + (operand1 / operand2);
            case "-" -> throw new IllegalOperationException("Operation '-' does not exist");
            case null -> throw new IllegalArgumentException("Operation cannot be null");
            case "" -> throw new IllegalArgumentException("Operation cannot be empty");
            default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        };
    }
}
