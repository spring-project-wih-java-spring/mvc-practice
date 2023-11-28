package test_code3.calculate;

import test_code3.NewArithmeticOperator;

public class DivOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if(operand2 == 0) {
            throw new IllegalArgumentException("0으로는 나눌수 없습니다.");
        }

        return operand1 / operand2;
    }
}
