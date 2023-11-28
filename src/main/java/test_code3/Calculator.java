package test_code3;

public class Calculator {

    public static int calculate(int opperand1, String operator, int opperand2){
        int answer = 0;

        return ArithmeticOperator.calculate(opperand1, operator, opperand2);

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
