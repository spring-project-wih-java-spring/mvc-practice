package test_code4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GradeCalculatorTest {

    @Test
    void calculateGradeTest() {
        List<Course> courses =
                Arrays.asList(
                        new Course("OOP", 3, "A+"),
                        new Course("자료구조", 3, "A+")
                );

                /* JAVA9 이상부터 사용가능
                List.of(
                new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+")
                );
                */

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculate();

        Assertions.assertThat(gradeResult).isEqualTo(4.5);

    }

}
