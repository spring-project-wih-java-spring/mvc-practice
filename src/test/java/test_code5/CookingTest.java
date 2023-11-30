package test_code5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookingTest {

    @DisplayName("메뉴에 해당하는 음식을 만든다")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking();
        MenuItem menuItem = new MenuItem("돈까스", 5000);
        Cook cook = cooking.makeCook(menuItem);

        Assertions.assertThat(cook).isEqualTo(new Cook("돈까스", 5000));
    }

    @DisplayName("요리를 생성")
    @Test
    void createTest() {
        Assertions.assertThatCode(() -> new Cook("만두", 5000))
                .doesNotThrowAnyException();
    }

}
