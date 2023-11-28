package test_code3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {

    @DisplayName("덧셈 연산을 정상적으로 수행")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    @Test
    void additionTest(int opperand1, String operator, int opperand2) {
        int result = Calculator.calculate(opperand1, operator, opperand2);
        Assertions.assertThat(result).isEqualTo(3);
    }


//    Stream<Arguments> formulaAndResult(){
//        return Streams.of(
//                arguments(1, "+", 2, 3),
//        )
//    }

}
