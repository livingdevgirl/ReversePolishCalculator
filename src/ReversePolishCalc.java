
public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
    private int stackTop;

    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {

        // 1. Use the String split method to split the string into tokens at the commas (using regex package)
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        stack = new String[tokens.length];


        // 3. write the algorithm
        for (int i = 0; i < tokens.length; i++) {
            // calls to push() and pop() and do the math here
            String token = tokens[i];

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                double operand1 = pop();
                double operand2 = pop();
                if (token.equals("+")) {
                    push(operand1 + operand2);

                } else if (token.equals("-")) {
                    push(operand1 - operand2);

                } else if (token.equals("*")) {
                    push(operand1 * operand2);

                } else if (token.equals("/")) {
                    push(operand1 / operand2);
                }
            } else {
                    push(token);
                }

            }
            // 4. return the result
            return pop();
        }





    private void push(String number) {
        stackTop++;
        stack[stackTop] = number;
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        String doubleString = Double.toString(d);
        push(doubleString);
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        stackTop--;
        return Double.parseDouble(stack[stackTop + 1]);
    }
}

