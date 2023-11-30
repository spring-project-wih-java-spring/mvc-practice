package test_code5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CustomerTest {

    @DisplayName("메뉴 이름에 해당하는 요리를 주문")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(Arrays.asList(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));
        Cooking cooking = new Cooking();
        Assertions.assertThatCode(() -> customer.order("만두", menu, cooking))
                .doesNotThrowAnyException();
    }
}
