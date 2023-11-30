package test_code5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    @DisplayName("메뉴 항목을 생성")
    @Test
    void createTest() {
        Assertions.assertThatCode(() -> new MenuItem("만두", 5000)).doesNotThrowAnyException();
    }
}
