package test_code3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("덧셈 연산을 정상적으로 수행")
    @Test
    void additionTest() {
        int result = Calculator.calculate(1, "+" , 2);

        Assertions.assertThat(result).isEqualTo(3);
    }

}
