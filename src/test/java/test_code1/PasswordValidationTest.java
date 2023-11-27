package test_code1;

import org.assertj.core.api.Assertions;
import test_code2.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
* [요구사항]
* - 비밀번호 최소 8자 이상, 12자 이하
* - 그외의 경우 IllegalArgumentException 예외 발생
* */
public class PasswordValidationTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외발생하지 않음.")
    @Test
    void validatePasswordTest() {
        Assertions.assertThatCode(() -> PasswordValidator.validate("abcd1234"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 이상, 12자 초과하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"}) // 경계값 테스트 중요
    @Test
    void validatePasswordTest2(String password) {
        Assertions.assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 합니다.");
    }





}
