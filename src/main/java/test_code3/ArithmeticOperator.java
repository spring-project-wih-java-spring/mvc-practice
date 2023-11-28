package test_code3;

import java.util.Arrays;

public enum ArithmeticOperator {

    ADD("+"){
        @Override
        public int arithmeticCalculate(int oper1, int oper2) {
            return oper1 + oper2;
        }
    },
    SUB("-"){
        @Override
        public int arithmeticCalculate(int oper1, int oper2) {
            return oper1 - oper2;
        }
    },

    MUL("*") {
        @Override
        public int arithmeticCalculate(int oper1, int oper2) {
            return oper1 * oper2;
        }
    },

    DIV("/") {
        @Override
        public int arithmeticCalculate(int oper1, int oper2) {
            if(oper2 == 0) {
                throw new IllegalArgumentException("0으로는 나눌수 없습니다.");
            }
            return oper1 / oper2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public static int calculate(int opperand1, String operator, int opperand2) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(value -> value.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return arithmeticOperator.arithmeticCalculate(opperand1, opperand2);
    }

    public abstract int arithmeticCalculate(final int oper1, final int oper2);
}
