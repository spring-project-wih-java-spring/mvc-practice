package test_code3;

import test_code3.calculate.AdditionOperator;
import test_code3.calculate.DivOperator;
import test_code3.calculate.MulOperator;
import test_code3.calculate.SubtractionOperator;

import java.util.List;

public class Calculator {

    // 방법3
//    private static final List<NewArithmeticOperator> arithmeticoperator = null;// = List.of(new AdditionOperator(), new SubtractionOperator(), new MulOperator(), new DivOperator());
    public static int calculate(int opperand1, String operator, int opperand2){

        // 방법3
//        return arithmeticoperator.stream()
//                .filter(arithmeticoperator -> arithmeticoperator.supports(operator))
//                .map(arithmeticoperator -> arithmeticoperator.calculate(opperand1, opperand2))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("올바른 사직연산이 아닙니다."));

        // 방법 2
        return ArithmeticOperator.calculate(opperand1, operator, opperand2);

        // 방법 1
//        switch (operator) {
//            case "+":
//                answer = opperand1 + opperand2;
//                return answer;
//            case "-":
//                answer = opperand1 - opperand2;
//                return answer;
//            case "*":
//                answer = opperand1 * opperand2;
//                return answer;
//            case "/":
//                answer = opperand1 / opperand2;
//                return answer;
//        }
//        return answer;
    }
}
