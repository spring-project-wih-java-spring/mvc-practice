package test_code3;

public class Calculator {

    public static int calculate(int opperand1, String operator, int opperand2){
        int answer = 0;
        if(operator == "+") {
            answer = opperand1 + opperand2;
            return answer;
        } else if (operator == "-") {
            answer = opperand1 - opperand2;
            return answer;
        } else if (operator == "*") {
            answer = opperand1 * opperand2;
            return answer;
        } else if (operator == "/") {
            answer = opperand1 / opperand2;
            return answer;
        }
        return answer;
    }
}
