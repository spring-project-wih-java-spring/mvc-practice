package test_code5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

public class MenuTest {

    @DisplayName("메뉴 이름에 해당하는 메뉴를 반환")
    @Test
    void chooseTest() {
        Menu menu = new Menu(Arrays.asList(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

        MenuItem menuItem = menu.choose("돈까스");

        Assertions.assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));
    }
}
