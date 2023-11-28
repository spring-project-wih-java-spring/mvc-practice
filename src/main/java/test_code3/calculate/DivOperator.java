package test_code3.calculate;

import test_code3.NewArithmeticOperator;

public class DivOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, String operator, int operand2) {
        return operand1 / operand2;
    }
}
