package test_code5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @DisplayName("요리를 생성")
    @Test
    void createTest() {
        Assertions.assertThatCode(() -> new Cook("만두", 5000))
                .doesNotThrowAnyException();
    }

}
